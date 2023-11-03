package com.qa.cardatabase.data.repository;

import com.qa.cardatabase.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
