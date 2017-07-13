package net.security.app.service;

import net.security.app.model.User;

public interface UserService {

    public void save(User user);

    public User findByName(String username);
}
