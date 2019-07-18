package demo.service.impl;

import demo.dao.EmailDao;
import demo.entity.Email;
import demo.entity.ServiceEmail;
import demo.entity.UserEmail;
import demo.service.EmailService;
import demo.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    
    @Resource
    private EmailDao<ServiceEmail> serviceEmailDao;

    @Resource
    private EmailDao<UserEmail> userEmailDao;

    @Override
    public void sendToUsers(Email email) {
        List<ServiceEmail> serviceEmails = serviceEmailDao.findAll();
        List<UserEmail> userEmails = userEmailDao.findAll();
        ServiceEmail ServiceEmail = serviceEmails.get(0);
        
        if (email == null) {
            email = new Email("来自xx团队的祝福", "祝您工作生活愉快！");
        }
        String[] sendEmails = userEmails.stream().toArray(String[]::new);
        try {
            EmailUtil.send(sendEmails, email, ServiceEmail);
        } catch (MessagingException e) {
            LOGGER.error("邮件发送失败\n[{}]", e.getMessage());
        }
    }
}
