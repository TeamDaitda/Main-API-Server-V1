package com.daitda.backend.service.serviceimpl;

import com.daitda.backend.dao.UserDao;
import com.daitda.backend.model.User;
import com.daitda.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public User registerUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public void modifyUser(String userId, User user) {
        userDao.updateUser(userId, user);
    }

    @Override
    public void removeUser(String userId) {
        userDao.deleteUser(userId);
    }
}
