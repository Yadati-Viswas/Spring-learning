package com.spring.project.jpa;

import com.spring.project.users.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryPost extends JpaRepository<Post,Integer> {
}
