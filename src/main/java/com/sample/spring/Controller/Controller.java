package com.sample.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.spring.Service.ServiceClass;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ServiceClass service;
    @RequestMapping("/")
    public String returnMsg(){
        return service.getMessage();
    }
}
