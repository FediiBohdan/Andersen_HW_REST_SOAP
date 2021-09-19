package com.weather.service;


import com.weather.db.dao.impl.UserDaoImpl;
import com.weather.db.model.User;

public class UserService {

    public static Long addUser(User user,short countryId, long cityId){
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.createUser(user,countryId,cityId);
    }
     public static String updateUser(User user){
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.updateUser(user);
     }

     public static User findByEmail(String email){
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.findByEMail(email);
     }

}
