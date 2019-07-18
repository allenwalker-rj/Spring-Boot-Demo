package demo.service;

import demo.entity.Email;

/**
 * 邮件服务接口
 */
public interface EmailService {
    
    void sendToUsers(Email email);
}
