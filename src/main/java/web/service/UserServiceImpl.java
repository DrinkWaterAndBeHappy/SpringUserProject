package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserVyId(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }
}
