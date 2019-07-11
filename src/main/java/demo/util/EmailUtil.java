package demo.util;

import demo.entity.Email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送
 *
 * @author mo
 */
public class EmailUtil {

    public static void send(String[] mailAddrs, Email email, String authCode) throws AddressException,MessagingException {
        int mailsNum = mailAddrs.length;
        InternetAddress[] addresses = new InternetAddress[mailsNum];
        for (int i = 0; i < mailsNum; i++) {
            addresses[i] = new InternetAddress(mailAddrs[i]);
        }
        send(addresses, email, authCode);
    }
    public static void send(InternetAddress[] addresses, Email email, String authCode) throws AddressException,MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.163.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("xxx@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, addresses);
        // 设置邮件标题
        message.setSubject(email.getSubject());
        // 设置邮件内容
        message.setText(email.getContent());
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("marcusmo@163.com", authCode);
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
