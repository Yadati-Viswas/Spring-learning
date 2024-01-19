package com.spring.project.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Version {
    @GetMapping("/v1/version")
    public PersonV1 FirstVersion(){
        return new PersonV1("Y Viswas");
    }
    @GetMapping("/v2/version")
    public PersonV2 SecondVersion(){
        return new PersonV2(new Name("Sai", "Viswas"));
    }
    @GetMapping(path="version", params = "1")
    public PersonV1 FirstVersionParams(){
        return new PersonV1("Y Viswas");
    }
    @GetMapping(path="version",params = "2")
    public PersonV2 SecondVersionParams(){
        return new PersonV2(new Name("Sai", "Viswas"));
    }
}
