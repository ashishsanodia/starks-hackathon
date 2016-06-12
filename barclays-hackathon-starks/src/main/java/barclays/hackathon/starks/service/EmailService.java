package barclays.hackathon.starks.service;

import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.web.vo.UserOffer;
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
import java.io.UnsupportedEncodingException;
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
    public void sendMailTo(User user, UserOffer userOffer) {
        final Context ctx = new Context();
        MimeMessage mimeMessage = null;
        MimeMessageHelper message = null;
        EmailVariables variables = getEmailVariablesFrom(user);
        Map<EmailVariables.Type, Object> map = variables.getMap();
        for (Map.Entry<EmailVariables.Type, Object> entry : map.entrySet()) {
            ctx.setVariable(entry.getKey().getName(), entry.getValue());
        }
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); // tre = multipart
            message.setSubject(variables.getMap().get(EmailVariables.Type.SUBJECT).toString());
            message.setFrom(new InternetAddress("gmail.com id", "Barclays Hackathon"));
            message.setTo(user.getEmail());
//        final String htmlContent = this.templateEngine.process(template, ctx);
            message.setText(userOffer.getUserName() + " " + userOffer.getOffer(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    private EmailVariables getEmailVariablesFrom(User user) {
        EmailVariables emailVariables = new EmailVariables();
        emailVariables.addNew(EmailVariables.Type.USER_NAME, user.getName());
        emailVariables.addNew(EmailVariables.Type.USER_EMAIL, user.getEmail());
        emailVariables.addNew(EmailVariables.Type.SUBJECT, "We have offer for you!!");
        return emailVariables;
    }
}
