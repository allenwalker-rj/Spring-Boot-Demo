package demo.service;

import demo.entity.GundamUser;
import demo.util.PageQuery;

import java.util.List;

/**
 * @author allen
 * @date 2019/6/19 13:55
 **/
public interface GundamUserService {

    public void save(GundamUser user);

    public void delete(GundamUser user);

    public List<GundamUser> findAll();

    public Object findPage(PageQuery pageQuery);
}
