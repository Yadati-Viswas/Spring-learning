package com.spring.project.jpa;

import com.spring.project.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryDb extends JpaRepository<Users,Integer> {
}
