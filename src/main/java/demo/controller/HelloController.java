package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo restful api
 * @author zhaomengwei
 */
@RestController
public class HelloController {
    
    @RequestMapping(value = {"/hello"})
    public String hello(){
        return "Hello, Master!";
    }
}
