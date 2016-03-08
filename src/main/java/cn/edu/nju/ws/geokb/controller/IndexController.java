package cn.edu.nju.ws.geokb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sloriac on 16/3/8.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("test");
        return "index";
    }
}