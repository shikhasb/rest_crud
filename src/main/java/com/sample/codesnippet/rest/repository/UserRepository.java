package com.sample.codesnippet.rest.repository;

import com.sample.codesnippet.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
