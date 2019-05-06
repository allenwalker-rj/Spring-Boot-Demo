package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * 视图控制器
 * 
 * @author zhaomengwei 
 */
@Controller
public class ViewController {
    
    @RequestMapping("/")
    public String index(ModelMap map){
        map.put("today", Calendar.getInstance());
        return "index";
    }
}
