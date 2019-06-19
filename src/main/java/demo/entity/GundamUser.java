package demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author allen
 * @date 2019/6/19 13:32
 **/
@Entity
@Table(name = "gundam_user")
@Data
public class GundamUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id  = -1L;

    @Column(name = "name" ,nullable = false)
    private String name = "";

    @Column(name = "gender",nullable = false)
    private String gender = "unknown";

    @Column(name = "age",nullable = false)
    private int age = 0;

    @Column(name = "state",nullable = false)
    private int state = 0;

    @Column(name = "created_time",nullable = false)
    private Date createdTime = null;

    @Column(name = "updated_time",nullable = false)
    private Date updatedTime = null;

}
