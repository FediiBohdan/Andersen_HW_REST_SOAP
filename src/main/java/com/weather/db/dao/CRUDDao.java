package com.weather.db.dao;

import com.weather.db.model.City;
import com.weather.db.model.Country;
import com.weather.db.model.User;

//import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface CRUDDao {

    User findByID(long id);

    User findByEMail(String email);

    //возвращает id созданного пользователя
    Long createUser(User user,short countryId,long cityId );

    //возвращает "success" или "fail"
    String deleteUser(long id);
    String updateUser(User user);

    //возвращает список упорядоченных по названию стран
    List<Country> getAllCountries();

    //возвращает список всех городов без ссылок на страны упорядоченных по названию
    List<City> getAllCities();

}
