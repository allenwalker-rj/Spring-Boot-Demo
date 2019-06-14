package demo.controller;

import demo.annotation.LoginCheck;
import demo.entity.SystemInfo;
import demo.entity.UserProfile;
import demo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * demo restful api
 *
 * @author zhaomengwei
 */
@RestController
@RequestMapping("/rest")
@Slf4j
public class HelloController {

    @Autowired
    private SystemInfo sysInfo;

    @Resource
    private AsyncService asyncService;

    @RequestMapping(value = {"/hello"})
    public String hello() {
        return "Hello, Master!";
    }

    @RequestMapping("/user")
    public UserProfile getUserProfile() {
        UserProfile profile = new UserProfile();
        profile.setName("admin");
        profile.setAge(25);
        return profile;
    }

    @RequestMapping("/sysinfo")
    public SystemInfo sysinfo() {
        return sysInfo;
    }

    @RequestMapping("/execute")
    @LoginCheck(forbidBlackUser = true)
    public String submit() {
        LOGGER.info("start submit");
        asyncService.executeAsync();
        LOGGER.info("end submit");
        return "success";
    }
}
