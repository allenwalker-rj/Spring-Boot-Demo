package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EmailDao<T> extends JpaRepository<T, String>, Serializable {
}
