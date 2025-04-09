package org.digitalcity.dto.resp.login;

import lombok.Builder;
import lombok.Data;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@Data
@Builder
public class MailVerifyRespDTO {
    private String mail;
    private String message;
}
