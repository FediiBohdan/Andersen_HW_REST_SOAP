package com.weather.service;


import com.weather.db.dao.impl.UserDaoImpl2;
import com.weather.db.model.User;

public class UserService {

    public static Long addUser(User user){
        UserDaoImpl2 userDao = new UserDaoImpl2();
        return userDao.createUser(user);
    }
     public static String updateUser(User user){
        UserDaoImpl2 userDao = new UserDaoImpl2();
        return userDao.updateUser(user);
     }

     public static User findByEmail(String email){
        UserDaoImpl2 userDao = new UserDaoImpl2();
        return userDao.findByEMail(email);
     }

}
