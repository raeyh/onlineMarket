package com.suk.market.service.user;

import com.suk.market.domain.User;

import java.util.Optional;

public interface UserService {
    User getUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String  password);
    Iterable<User> findAllUser();
    Optional<User> findUserById(long id);
    void save(User user);
    void updateUser(User user);
    void deleteById(long id);
}
