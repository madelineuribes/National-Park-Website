package com.techelevator.npgeek.Model.Weather;

import java.text.DecimalFormat;

public class Weather {

	private String parkCode;
	private int highTemp;
	private int lowTemp;
	private int dayValue;
	private String forecast;
	private Double celsiusLow;
	private Double celsiusHigh;
	private Double fahrenheitHigh;
	private Double fahrenheitLow;
	

	public String getParkCode() { 
		return parkCode; 
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getHighTemp() {
		return highTemp;
	}

	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp; 
	}

	public int getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}

	public int getDayValue() {
		return dayValue;
	}

	public void setDayValue(int dayValue) {
		this.dayValue = dayValue;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
public Double getCelsiusLow() {
		
		DecimalFormat df = new DecimalFormat("#.##");      
		Double results =(fahrenheitLow - 32.0) * (5.0 / 9.0);
		results = Double.valueOf(df.format(results));
		
		return results;
	} 

	public void setCelsiusLow(Double celsiusLow) {
		this.celsiusLow = celsiusLow;
	} 

	public Double getCelsiusHigh() {
		DecimalFormat df = new DecimalFormat("#.##");      
		Double result =(fahrenheitHigh - 32.0) * (5.0 / 9.0);
		result = Double.valueOf(df.format(result));

		return result;
	}

	public void setCelsiusHigh(Double celsiusHigh) {
		this.celsiusHigh = celsiusHigh;
	}
}
