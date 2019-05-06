package demo.controller;

import demo.entity.UserProfile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo restful api
 * @author zhaomengwei
 */
@RestController
@RequestMapping("/rest")
public class HelloController {
    
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
}
