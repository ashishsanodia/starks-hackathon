package barclays.hackathon.starks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendMailTo(EmailVariables variables, String template) throws MessagingException, IOException {
        final Context ctx = new Context();
        Map<EmailVariables.Type, Object> map = variables.getMap();
        for (Map.Entry<EmailVariables.Type, Object> entry : map.entrySet()) {
            ctx.setVariable(entry.getKey().getName(), entry.getValue());
        }
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); // tre = multipart
        message.setSubject(variables.getMap().get(EmailVariables.Type.SUBJECT).toString());
        message.setFrom(new InternetAddress("gmail.com id", "Barclays Hackathon"));
        message.setTo(variables.getMap().get(EmailVariables.Type.USER_EMAIL).toString());
//        final String htmlContent = this.templateEngine.process(template, ctx);
        message.setText("some-message", true);
        javaMailSender.send(mimeMessage);
    }
}
