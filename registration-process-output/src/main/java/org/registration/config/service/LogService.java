package org.registration.config.service;

import lombok.RequiredArgsConstructor;
import org.registration.config.entity.User;
import org.registration.config.repository.CustomizedUserCrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final CustomizedUserCrudRepository repository;

    public void saveUser(User user) {
        repository.save(user);
    }

    public User getUser(String nickname) {
        return repository.findById(nickname).orElse(null);
    }
}
