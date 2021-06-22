package org.registration.config.repository;

import org.registration.config.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomizedUserCrudRepository extends CrudRepository<User, String> {
    List<User> findAll();
}