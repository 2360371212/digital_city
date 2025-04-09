package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.req.*;
import org.digitalcity.dto.resp.login.MailVerifyRespDTO;
import org.digitalcity.dto.resp.login.UserLoginRespDTO;
import org.digitalcity.dto.resp.login.UserPasswordUpdateRespDTO;
import org.digitalcity.dto.resp.login.UserRegisterRespDto;

public interface IMemberService {
    public RestResp<UserRegisterRespDto> register(UserRegisterReqDto userRegisterReqDto);

    public RestResp<MailVerifyRespDTO> verifyEmailSend(MailVerifyReqDTO mailVerifyReqDTO);

    public RestResp<UserPasswordUpdateRespDTO> updatePassword(UserPasswordUpdateReqDTO userPasswordUpdateReqDTO);

    public RestResp<UserLoginRespDTO> login(UserLoginReqDTO userLoginReqDTO);
}
