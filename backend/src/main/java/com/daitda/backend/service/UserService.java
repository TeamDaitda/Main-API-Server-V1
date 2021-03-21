package com.daitda.backend.service;

import com.daitda.backend.dao.UserDao;
import com.daitda.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public User getUserByUserId(String userId);

    public User registerUser(User user);

    public void modifyUser(String userId, User user);

    public void removeUser(String userId);
}
