package com.techelevator.npgeek.Model.Weather;

import java.util.List;

import com.techelevator.npgeek.Model.Park.Park;

public interface WeatherDao {
	
	public List<Weather> getWeather();
	
	public List<Weather> getWeatherById(String parkCode);
 
} 
