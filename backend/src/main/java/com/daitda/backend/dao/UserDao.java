package com.daitda.backend.dao;


import com.daitda.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDao {

    public List<User> getAllUsers();

    public User getUserByUserId(String userId);

    public User insertUser(User user);

    public void updateUser(String userId, User user);

    public void deleteUser(String userId);
}
