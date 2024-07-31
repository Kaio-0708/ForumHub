package com.alura.forum.repository;

import com.alura.forum.core.crud.CrudRepository;
import com.alura.forum.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    UserDetails findByLogin(String login);
}
