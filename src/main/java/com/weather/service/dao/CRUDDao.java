package com.weather.service.dao;

import com.weather.service.model.City;
import com.weather.service.model.Country;
import com.weather.service.model.User;

//import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface CRUDDao {

    User findByID(long id);

    User findByEMail(String email);
    String createUser(User user);
    String deleteUser(long id);
    String updateUser(User user);
    List<Country> getAllCountries();
    List<City> getAllCities();

}
