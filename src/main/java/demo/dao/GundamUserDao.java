package demo.dao;

import demo.entity.GundamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author allen
 * @date 2019/6/19 13:51
 **/
public interface GundamUserDao extends JpaRepository<GundamUser, Long>, Serializable {
}
