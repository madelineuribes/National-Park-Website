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
	public List<Weather> getWeather() {
		List<Weather> weatherList = new ArrayList<>();
		String sqlSelectAllWeather = "SELECT * FROM weather";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeather);
		while(results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		return weatherList;
	}
	
	@Override
	public List<Weather> getWeatherById(String parkCode) {
		List<Weather> weatherList = new ArrayList<>();
		String sqlSelectParkById = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkById, parkCode);
		if(results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		return weatherList; 
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setDayValue(results.getInt("fivedayforecastvalue"));
		weather.setForecast(results.getString("forecast"));
		weather.setHighTemp(results.getInt("high"));
		weather.setLowTemp(results.getInt("low"));
		weather.setParkCode(results.getString("parkcode"));
		return weather;
	}
	
}
 