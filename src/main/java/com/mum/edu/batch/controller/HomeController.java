package com.mum.edu.batch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "login successfull, to process the batch job please hit the url: localhost:8080/processbatch";
    }
}
