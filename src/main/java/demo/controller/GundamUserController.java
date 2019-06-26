package demo.controller;

import demo.annotation.LoginCheck;
import demo.entity.GundamUser;
import demo.holder.ParamsHolder;
import demo.service.GundamUserService;
import demo.util.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author allen
 * @date 2019/6/19 14:06
 **/
@RestController
public class GundamUserController {

    @Autowired
    private GundamUserService gundamUserService;


    @GetMapping(value = "/user/token")
    @LoginCheck
    public Object token(){
        return ParamsHolder.get();
    }

    @PostMapping(value = "/user/save")
    public Object save(@RequestBody GundamUser user) {
        gundamUserService.save(user);
        return 1;
    }

    @PostMapping(value = "/user/delete")
    public Object delete(@RequestBody GundamUser user) {
        gundamUserService.delete(user);
        return 1;
    }

    @GetMapping(value = "/user/findOne")
    public Object findOne(HttpServletRequest request, @RequestParam("uid") long uid) {
        return gundamUserService.findOne(uid);
    }

    @GetMapping(value = "/user/findAll")
    public Object findAll(HttpServletRequest request) {
        return gundamUserService.findAll();
    }

    @PostMapping(value = "/user/findPage")
    public Object findPage(@RequestBody PageQuery pageQuery) {
        return gundamUserService.findPage(pageQuery);
    }

}
