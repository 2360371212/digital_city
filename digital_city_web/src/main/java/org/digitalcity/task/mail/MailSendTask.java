package org.digitalcity.task.mail;

import lombok.extern.slf4j.Slf4j;
import org.digitalcity.common.util.ValidateCodeGenerator;
import org.digitalcity.manager.VerifyCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@Component
@EnableAsync
@Slf4j
public class MailSendTask {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VerifyCodeManager codeManager;

    @Async
    public void sendVerifyMail(String mail, int type) {
        String validateCode = ValidateCodeGenerator.createRandom(false, 6);
        // 将验证码保存到redis中方便后期校验

        codeManager.save(mail, type, validateCode);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2360371212@qq.com");
        message.setTo(mail);
        message.setSubject("验证码！");
        message.setText(validateCode);
        this.javaMailSender.send(message);
    }
}
