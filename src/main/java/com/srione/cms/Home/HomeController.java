package com.srione.cms.Home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @GetMapping
    public String handleWhiteLabel(){
        return "Application is working absolutely amazing!!! " +new Date();
    }
}
