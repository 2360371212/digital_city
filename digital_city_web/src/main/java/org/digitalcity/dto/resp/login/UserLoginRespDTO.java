package org.digitalcity.dto.resp.login;

import lombok.Builder;
import lombok.Data;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/24
 */
@Data
@Builder
public class UserLoginRespDTO {
    private String mail;
    private String token;
    private String message;
}
