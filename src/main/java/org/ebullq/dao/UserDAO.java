package org.ebullq.dao;

import org.ebullq.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByLogin(String login);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

}
