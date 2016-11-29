package com.sudhir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:9/11/16
 *         Time:8:10 AM
 *         Project:reservation-services
 */
@RefreshScope
@RestController
public class TestRestController {
    @Value("${greeting-message}")
    private String greetMessage;
    @RequestMapping(path = "greet",method = RequestMethod.GET)
    public String greeting(){
        return "Good Morning";
    }
    //@RequestMapping(path="greetme")

    @GetMapping(path = "greetme")
    public  String returnGreetingMessage(){
        return greetMessage;
    }

    @RequestMapping(path = "/")
    public String home(){
        return "Hello";
    }
}
