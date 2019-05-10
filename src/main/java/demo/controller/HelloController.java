package demo.controller;

import demo.entity.SystemInfo;
import demo.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo restful api
 * @author zhaomengwei
 */
@RestController
@RequestMapping("/rest")
public class HelloController {
    @Autowired
    private SystemInfo sysInfo;
    
    @RequestMapping(value = {"/hello"})
    public String hello(){
        return "Hello, Master!";
    }
    
    @RequestMapping("/user")
    public UserProfile getUserProfile(){
        UserProfile profile = new UserProfile();
        profile.setName("admin");
        profile.setAge(25);
        return profile;
    }

    @RequestMapping("/sysinfo")
    public SystemInfo sysinfo(){
        return sysInfo;
    }
}
