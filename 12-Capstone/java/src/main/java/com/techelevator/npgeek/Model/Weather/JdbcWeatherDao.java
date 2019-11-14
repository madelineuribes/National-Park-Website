package com.techelevator.npgeek.Model.Weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {

private JdbcTemplate jdbcTemplate;

@Autowired
public JdbcWeatherDao(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
}

@Override
public List<Weather> getWeatherById(String parkCode) {
    List<Weather> weatherList = new ArrayList<>();
    String sqlSelectParkById = "SELECT * FROM weather WHERE parkcode = ?";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkById, parkCode);
    while(results.next()) {
        weatherList.add(mapRowToWeather(results));
    }
    return weatherList; 
}

private Weather mapRowToWeather(SqlRowSet results) { 
    Weather weather = new Weather();
    weather.setDayValue(results.getInt("fivedayforecastvalue"));
    weather.setForecast(results.getString("forecast"));
	weather.setLowF(results.getInt("low"));
	weather.setHighF(results.getInt("high"));
	weather.setLowC((results.getInt("low")-32)*5/9);
	weather.setHighC((results.getInt("high")-32)*5/9);
    weather.setParkCode(results.getString("parkcode"));
    return weather;
}
}









