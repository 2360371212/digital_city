package org.digitalcity.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/30
 */
@Data
public class UserPasswordUpdateReqDTO {
    //  @Email(message = "邮箱地址不符合格式")
    @NotBlank(message = "邮箱不能为空")
    private String mail;
    @NotBlank(message = "验证码不能为空")
    private String valCode;
    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 15, message = "密码长度不符合要求")
    private String password;
}
