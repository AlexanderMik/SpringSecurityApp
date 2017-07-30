package net.security.app.service;

public interface SecurityService {

    String findLoggedInUsername(String username);

    void autoLogin(String username, String password);
}
