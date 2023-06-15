package com.myCompany.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainClass {



    @GetMapping("")
    public String showHomePage()
    {
        return "index";
    }
}
