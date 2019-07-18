package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "client_email")
public class UserEmail {
    @Column(name = "USER_ID" ,nullable = false)
    private String userId;
    @Column(name = "EMAIL" ,nullable = false)
    private String email;
}
