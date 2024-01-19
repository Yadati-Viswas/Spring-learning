package com.spring.project.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class filterClass {
    @GetMapping("/filtering")
    public fewFields filterMethod(){
        return new fewFields("value1","value2","value3");
    }
    @GetMapping("/filtering-list")
    public List<fewFields> filterMethodlist(){
        return Arrays.asList(new fewFields("value1", "value2", "value3"),new fewFields("value1","value2","value3"));
    }
}
