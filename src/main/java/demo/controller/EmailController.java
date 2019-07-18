package demo.controller;

import demo.entity.Email;
import demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    public void sendEmail(@RequestBody Email email) {
        emailService.sendToUsers(email);
    }
}
