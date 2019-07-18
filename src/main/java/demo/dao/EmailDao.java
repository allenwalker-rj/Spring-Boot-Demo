package demo.dao;

import demo.entity.ServiceEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EmailDao extends JpaRepository<ServiceEmail, Long>, Serializable {
}
