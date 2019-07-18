package demo.controller;

import demo.entity.Email;
import demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/go")
    public void sendEmail(@RequestBody Email email) {
        emailService.sendToUsers(email);
    }
}
