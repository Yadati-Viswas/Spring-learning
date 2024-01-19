package com.spring.project.HelloWorldController;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {
    private MessageSource messageSource;
    public HelloWorld(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping(path="/helloworld")
    public String Helloworld(){
        return "Hello, I'm Ydsv";
    }
    @GetMapping(path="/helloworld-i18n")
    public String HelloworldMessages(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
    }
    @GetMapping(path="/helloworldbean/{name}")
    public HelloWorldBean HelloworldBean(@PathVariable String name){
        return new HelloWorldBean("Hello Bean "+name);
    }
}
