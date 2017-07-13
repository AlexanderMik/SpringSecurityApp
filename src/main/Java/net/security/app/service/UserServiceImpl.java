package net.security.app.service;

import net.security.app.dao.RoleDao;
import net.security.app.dao.UserDao;
import net.security.app.model.User;
import net.security.app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1));
        user.setRoles(roles);
        userDao.save(user);

    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}
