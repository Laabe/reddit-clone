package com.reddit.email.service;

import com.reddit.email.exception.SpringRedditException;
import com.reddit.email.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MailService {
    private final JavaMailSender javaMailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    public void sendMail(NotificationEmail notificationEmail) throws SpringRedditException {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("zlaabane@gmail.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Activation email sent!!!");
        } catch (MailException e) {
            throw new SpringRedditException(
                    "Exception occurred when sending email to " + notificationEmail.getRecipient()
            );
        }
    }
}
