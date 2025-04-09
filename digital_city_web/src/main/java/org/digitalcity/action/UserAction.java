package org.digitalcity.action;

import jakarta.validation.Valid;
import org.digitalcity.common.action.abs.AbsBaseAction;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.req.*;
import org.digitalcity.dto.resp.login.MailVerifyRespDTO;
import org.digitalcity.dto.resp.login.UserLoginRespDTO;
import org.digitalcity.dto.resp.login.UserPasswordUpdateRespDTO;
import org.digitalcity.dto.resp.login.UserRegisterRespDto;
import org.digitalcity.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/24
 */
@RestController
@RequestMapping("/digital_city/user/")
public class UserAction extends AbsBaseAction {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private IMemberService memberService;

    @PostMapping("register")
    public RestResp<UserRegisterRespDto> register(@RequestBody @Valid UserRegisterReqDto userRegisterReqDto) {
        return memberService.register(userRegisterReqDto);
    }

    @PostMapping("send_mail")
    public RestResp<MailVerifyRespDTO> sendMail(@RequestBody @Valid MailVerifyReqDTO mailVerifyReqDTO) {
        return memberService.verifyEmailSend(mailVerifyReqDTO);
    }

    @PostMapping("update_password")
    public RestResp<UserPasswordUpdateRespDTO> updatePassword(@RequestBody @Valid UserPasswordUpdateReqDTO userPasswordUpdateReqDTO) {
        return memberService.updatePassword(userPasswordUpdateReqDTO);
    }

    @PostMapping("login")
    public RestResp<UserLoginRespDTO> login(@RequestBody @Valid UserLoginReqDTO userLoginReqDTO) {
        RestResp<UserLoginRespDTO> login = memberService.login(userLoginReqDTO);
        String token = UUID.randomUUID().toString();
        // 登入有效时常24小时
        redisTemplate.opsForValue().set("token:" + token, login.getData().toString(), 24, TimeUnit.HOURS);
        login.getData().setToken(token);
        return login;
    }
}
