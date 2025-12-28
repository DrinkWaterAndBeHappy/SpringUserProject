package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getUsers();
    void deleteUserVyId(long id);
    void updateUser(User user);
    User getUserById(long id);
}
