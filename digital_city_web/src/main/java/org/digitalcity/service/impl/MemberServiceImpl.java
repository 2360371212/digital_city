package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.digitalcity.common.enu.ErrorCodeEnum;
import org.digitalcity.common.exception.BusinessException;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.common.util.MD5Util;
import org.digitalcity.dao.IMemberDAO;
import org.digitalcity.dao.entity.Member;
import org.digitalcity.dto.req.*;
import org.digitalcity.dto.resp.login.MailVerifyRespDTO;
import org.digitalcity.dto.resp.login.UserLoginRespDTO;
import org.digitalcity.dto.resp.login.UserPasswordUpdateRespDTO;
import org.digitalcity.dto.resp.login.UserRegisterRespDto;
import org.digitalcity.service.IMemberService;
import org.digitalcity.task.mail.MailSendTask;
import org.digitalcity.manager.VerifyCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Description: 用户注册业务类
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberDAO memberDAO;

    @Autowired
    private MailSendTask mailSendTask;
    @Autowired
    private VerifyCodeManager verifyCodeManager;

    // 用户注册
    public RestResp<UserRegisterRespDto> register(UserRegisterReqDto userRegisterReqDto) {
        if (!verifyCodeManager.validate(userRegisterReqDto.getMail(), 0, userRegisterReqDto.getValCode())) {
            throw new BusinessException(ErrorCodeEnum.USER_VERIFY_CODE_ERROR);
        }
        Member member = new Member();
        verifyCodeManager.delete(userRegisterReqDto.getMail(), 0);
        member.setMail(userRegisterReqDto.getMail());
        member.setPassword(MD5Util.md5Encode(userRegisterReqDto.getPassword()));
        memberDAO.insert(member);
        return RestResp.ok(UserRegisterRespDto.builder().mail(userRegisterReqDto.getMail()).message("注册成功").build());
    }

    // 注册时发送邮件
    public RestResp<MailVerifyRespDTO> verifyEmailSend(MailVerifyReqDTO mailVerifyReqDTO) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mail", mailVerifyReqDTO.getMail());
        Long result = memberDAO.selectCount(queryWrapper);
        // 注册时用户已经存在,抛出已经被注册
        if (result > 0 && mailVerifyReqDTO.getType() == 0) {
            throw new BusinessException(ErrorCodeEnum.USER_NAME_EXIST);
        }
        // 修改密码时，用户还没有注册,抛出用户不存在
        if (result == 0 && mailVerifyReqDTO.getType() == 1) {
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }
        mailSendTask.sendVerifyMail(mailVerifyReqDTO.getMail(), mailVerifyReqDTO.getType());
        return RestResp.ok(MailVerifyRespDTO.builder().mail(mailVerifyReqDTO.getMail()).message("邮件发送成功").build());
    }


    // 更新密码(重制密码)
    public RestResp<UserPasswordUpdateRespDTO> updatePassword(UserPasswordUpdateReqDTO userPasswordUpdateReqDTO) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mail", userPasswordUpdateReqDTO.getMail());
        if (memberDAO.selectCount(queryWrapper) == 0) {
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }
        // 如果验证码错误
        if (!verifyCodeManager.validate(userPasswordUpdateReqDTO.getMail(), 1, userPasswordUpdateReqDTO.getValCode())) {
            throw new BusinessException(ErrorCodeEnum.USER_VERIFY_CODE_ERROR);
        }
        UpdateWrapper<Member> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("password", MD5Util.md5Encode(userPasswordUpdateReqDTO.getPassword()));
        updateWrapper.set("update_time", LocalDateTime.now());
        updateWrapper.eq("mail", userPasswordUpdateReqDTO.getMail());
        memberDAO.update(null, updateWrapper);
        verifyCodeManager.delete(userPasswordUpdateReqDTO.getMail(), 1);
        return RestResp.ok(UserPasswordUpdateRespDTO.builder().message("密码更新成功").build());
    }

    // 用户登入
    public RestResp<UserLoginRespDTO> login(UserLoginReqDTO userLoginReqDTO) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mail", userLoginReqDTO.getMail()).eq("password", MD5Util.md5Encode(userLoginReqDTO.getPassword())).eq("status", 0);
        if (memberDAO.selectCount(queryWrapper) < 1) {
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }
        return RestResp.ok(UserLoginRespDTO.builder().message("用户登入成功").mail(userLoginReqDTO.getMail()).build());
    }
}
