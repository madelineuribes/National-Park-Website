package com.techelevator.npgeek.Model.Weather;

public class Weather {

	private String parkCode;
	private int dayValue;
	private String forecast;
	private double highF;
	private double lowF;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
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

	public double getHighF() {
		return highF;
	}

	public void setHighF(double highF) {
		this.highF = highF;
	}

	public double getLowF() {
		return lowF;
	} 

	public void setLowF(double lowF) {
		this.lowF = lowF;
	}

}
