package com.spring.project.users;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service=service;
    }
    @GetMapping("/users")
    public List<Users> retrieveAll(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Users> retrieveSpecific(@PathVariable int id){
        Users user= service.findSpecific(id);
        if(user ==null) {
            throw new UserNotFoundException("id :"+id);
        }
        EntityModel<Users> eM= EntityModel.of(user);
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAll());
        eM.add(link.withRel("all-users"));
        return eM;
    }
    @DeleteMapping("/users/{id}")
    public void DeleteSpecific(@PathVariable int id){
        service.deleteSpecific(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Users> saveUser(@Valid @RequestBody Users user){
        Users users=service.AddUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(users).toUri();
        return ResponseEntity.created(location).build();
    }

}
