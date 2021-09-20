package com.weather.db.dao.impl;
import com.weather.db.dao.*;
import com.weather.db.dao.pool.ConnectionPool;
import com.weather.db.model.City;
import com.weather.db.model.Country;
import com.weather.db.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
            "email=? and u.isdeleted=false";
    private static final String ALL_USERS_BY_ID="SELECT * FROM andersen.User order by id";
    private static final String CREATE_USER="INSERT INTO andersen.User(name," +
            "email,country_id,city_id,dateOfLastUpdate,dateOfCreation,isDeleted)" +
            "VALUES(?,?,?,?,?,?,?) returning id;";
    private static final String DELETE_USER_BY_ID="UPDATE andersen.User SET " +
            "isDeleted=TRUE WHERE id=? returning id;";
    private static final String UPDATE_USER="UPDATE andersen.User SET" +
            "name=?, email=?, country_id=?, city_id=?,dateOfLastUpdate=? WHERE id=? returning id;";
    private static final String ALL_COUNTRY_ORDERED_BY_NAME= "SELECT * FROM andersen.Country order by name;";
    private static final String FIND_CITIES_BY_COUNTRY_ORDERED_BY_NAME="SELECT * FROM andersen.City " +
            "where country_id=? order by name;";
    private static final String ALL_CITIES_ORDERED_BY_NAME="SELECT * FROM andersen.City order by name;";

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
    public Long createUser(User user, short countryId, long cityId) {
        Long idret =null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setShort(3,countryId);
            preparedStatement.setLong(4,cityId);
            preparedStatement.setObject(5,user.getDateOfLastUpdate());
            preparedStatement.setObject(6,user.getDateOfCreation());
            preparedStatement.setBoolean(7,user.getDeleted());
            ResultSet resultSet =preparedStatement.executeQuery();
            resultSet.next();
            idret=resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idret;
    }

    @Override
    public String deleteUser(long id) {
        String result ="";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1,id);
            int rowAffected =preparedStatement.executeUpdate();
            if (rowAffected>0) {
                result="success";
            } else {
                result="fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        String result ="";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setShort(3,User.getCountries().get(user.getCountry()).getId());
            preparedStatement.setLong(4,User.getCities().get(user.getCity()).getId());
            preparedStatement.setObject(5,LocalDateTime.now());
            int rowAffected =preparedStatement.executeUpdate();
            if (rowAffected>0) {
                result="success";
            } else {
                result="fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries =new ArrayList<>();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(ALL_COUNTRY_ORDERED_BY_NAME);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                Short countryId =resultSet.getShort("id");
                List citiesFromThatCountry =new ArrayList<>();
                preparedStatement=connection.prepareStatement(FIND_CITIES_BY_COUNTRY_ORDERED_BY_NAME);
                preparedStatement.setShort(1,countryId);
                ResultSet resultSetOfCities =preparedStatement.executeQuery();
                while (resultSetOfCities.next()){
                    citiesFromThatCountry.add(new City(resultSetOfCities.getLong("id"),
                            resultSetOfCities.getString("name"),
                            resultSetOfCities.getString("lat"),
                            resultSetOfCities.getString("lon")));
                }
                countries.add(new Country(countryId,resultSet.getString("name"), citiesFromThatCountry));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities =new ArrayList<>();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(ALL_CITIES_ORDERED_BY_NAME);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                cities.add(new City(resultSet.getLong("id"),resultSet.getString("name"),
                            resultSet.getString("lat"),resultSet.getString("lon")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cities;
    }
}
