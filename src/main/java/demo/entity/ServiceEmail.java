package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sys_email")
public class ServiceEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id  = -1;
    @Column(name = "EMAIL" ,nullable = false)
    private String email;
    @Column(name = "SMTP_HOST" ,nullable = false)
    private String smtpHost;
    @Column(name = "SMTP_PORT" ,nullable = false)
    private String smtpPort;
    @Column(name = "AUTH_CODE" ,nullable = false)
    private String authCode;
}
