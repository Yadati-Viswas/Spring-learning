package com.spring.project.users;

import com.spring.project.jpa.JpaRepositoryDb;
import com.spring.project.jpa.JpaRepositoryPost;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    @Autowired
    private JpaRepositoryDb jrd;
    @Autowired
    private JpaRepositoryPost jrp;
    public UserJpaResource(JpaRepositoryDb jrd){
        this.jrd=jrd;
    }
    @GetMapping("/jpa/users")
    public List<Users> retrieveAll(){
        return jrd.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<Users> retrieveSpecific(@PathVariable int id){
        Optional<Users> user= jrd.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id :"+id);
        }
        EntityModel<Users> eM= EntityModel.of(user.get());
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAll());
        eM.add(link.withRel("all-users"));
        return eM;
    }
    @DeleteMapping("/jpa/users/{id}")
    public void DeleteSpecific(@PathVariable int id){
        jrd.deleteById(id);
    }
    @PostMapping("/jpa/users")
    public ResponseEntity<Users> saveUser(@Valid @RequestBody Users user){
        Users users=jrd.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(users.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsbyUserId(@PathVariable int id){
        Optional<Users> user= jrd.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id :"+id);
        }
        return user.get().getPost();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Users> CreatePostsbyUserId(@PathVariable int id,@Valid @RequestBody Post posts){
        Optional<Users> user= jrd.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id :"+id);
        }
        posts.setUser(user.get());
        Post post=jrp.save(posts);
        URI location= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(post.getId()).toUri();
        System.out.println(location);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts/{postId}")
    public Optional<Post> GetPostsbyUserIdAndPostId(@PathVariable int id,@PathVariable int postId){
        Optional<Users> user= jrd.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id :"+id);
        }
        Optional<Post> postById=jrp.findById(postId);
        return postById;
    }

}
