package org.digitalcity.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@Data
public class MailVerifyReqDTO {
    @Email(message = "邮箱地址不符合格式")
    @NotBlank(message = "邮箱不能为空")
    private String mail;

    @NotNull(message = "类型不能为空，0:注册，1:更新")
    // 0:注册  1:更新密码
    private int type;
}
