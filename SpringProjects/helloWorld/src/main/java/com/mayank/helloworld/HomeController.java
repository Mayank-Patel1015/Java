package com.mayank.helloworld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
        @RequestMapping("/")
        public String hello() {
                return "demo.jsp";
        }
}