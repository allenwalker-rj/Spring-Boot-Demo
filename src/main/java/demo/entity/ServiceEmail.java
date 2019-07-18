package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "sys_email")
public class ServiceEmail {
    @Column(name = "EMAIL" ,nullable = false)
    private String email;
    @Column(name = "SMTP_HOST" ,nullable = false)
    private String smtpHost;
    @Column(name = "SMTP_PORT" ,nullable = false)
    private String smtpPort;
    @Column(name = "AUTH_CODE" ,nullable = false)
    private String authCode;
}
