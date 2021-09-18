package com.weather.service.dao.impl;
import com.weather.service.dao.*;
import com.weather.service.dao.pool.ConnectionPool;
import com.weather.service.model.City;
import com.weather.service.model.Country;
import com.weather.service.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoImpl implements CRUDDao {
    private static final String FIND_USER_BY_ID ="select u.id as id,u.name as name,u.email as email," +
            "s.name as country,g.name as city,u.dateoflastupdate as dateoflastupdate," +
            "u.dateofcreation as dateofcreation,u.isdeleted as isdeleted from andersen.User u" +
            " join andersen.Country s on u.country_id = s.id join andersen.City g on u.city_id = g.id where u.id=?" +
            "and u.isdeleted=false ";
    private static final String FIND_USER_BY_EMAIL="select u.id as id,u.name as name,u.email as email," +
            "s.name as country,g.name as city,u.dateoflastupdate as dateoflastupdate," +
            "u.dateofcreation as dateofcreation,u.isdeleted as isdeleted from andersen.User" +
            "join andersen.Country s on u.country_id = s.id join andersen.City g on u.city_id = g.id where where " +
            "email=?";
    private static final String ALL_USERS_BY_ID="SELECT * FROM andersen.Users order by id";
    private static final String CREATE_USER="INSERT INTO andersen.User (name,\" +\n" +
            "            \"email,country_id,city_id,dateOfLastUpdate,dateOfCreation,isDeleted)\" +\n" +
            "            \"VALUES(?,?,?,?,?,?,?) returning id;";
    private static final String DELETE_USER_BY_ID="UPDATE andersen.User SET " +
            "isDeleted=TRUE WHERE id=? returning id;";
    private static final String UPDATE_USER="UPDATE andersen.User SET" +
            "name=?, email=?, country_id=?, city_id=? WHERE id=? returning id";

    private static Connection connection;

    static {
        try {
            connection= ConnectionPool.getInstance().getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static UserDaoImpl instance;

    public static UserDaoImpl getInstance(){
        if(instance==null){
            instance=new UserDaoImpl();
        }
        return instance;
    }


    @Override
    public User findByID(long id) {
        User user =null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("name"),
                         resultSet.getString("email"), resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                        resultSet.getObject("dateOfCreation", LocalDateTime.class),
                        resultSet.getBoolean("isDeleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByEMail(String email) {
        User user =null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_USER_BY_EMAIL);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("name"),
                        resultSet.getString("email"), resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                        resultSet.getObject("dateOfCreation", LocalDateTime.class),
                        resultSet.getBoolean("isDeleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String createUser(User user) {
        Long idret=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setShort(3,User.getCountries().get(user.getCountry()).getId());
            preparedStatement.setLong(4,User.getCities().get(user.getCity()).getId());
            preparedStatement.setObject(5,user.getDateOfLastUpdate());
            preparedStatement.setObject(6,user.getDateOfCreation());
            preparedStatement.setBoolean(7,user.getDeleted());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String deleteUser(long id) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String updateUser(User user) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setShort(3,User.getCountries().get(user.getCountry()).getId());
            preparedStatement.setLong(4,User.getCities().get(user.getCity()).getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<Country> getAllCountries() {
        return null;
    }

    @Override
    public List<City> getAllCities() {
        return null;
    }


//    @Override
//    public List<User> viewAllUsers() {
//        List<User> users =new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement=connection.prepareStatement(ALL_USERS_BY_ID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                users.add(new User(resultSet.getLong("id"), resultSet.getString("name"),
//                        resultSet.getString("email"), resultSet.getString("country"),
//                        resultSet.getString("city"),
//                        resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
//                        resultSet.getObject("dateOfCreation", LocalDateTime.class),
//                        resultSet.getBoolean("isDeleted")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
}
