package org.digitalcity.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/24
 */
@Data
public class UserLoginReqDTO {
    //    @Email(message = "邮箱地址不符合格式")
    @NotBlank(message = "邮箱不能为空")
    public String mail;

    @NotBlank(message = "密码不能为空")
    public String password;
}
