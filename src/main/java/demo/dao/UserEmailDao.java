package demo.dao;

import demo.entity.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserEmailDao extends JpaRepository<UserEmail, Long>, Serializable {
}
