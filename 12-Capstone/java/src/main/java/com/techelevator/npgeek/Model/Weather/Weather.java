package com.techelevator.npgeek.Model.Weather;

public class Weather {

	private String parkCode;
	private int dayValue;
	private String forecast;
	private int lowC;
	private int highC;
	private int highF;
	private int lowF;

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

	public int getLowC() {
		return lowC;
	}

	public void setLowC(int lowC) {
		this.lowC = lowC;
	}

	public int getHighC() {
		return highC;
	}

	public void setHighC(int highC) {
		this.highC = highC;
	}

	public int getHighF() {
		return highF;
	}

	public void setHighF(int highF) {
		this.highF = highF;
	}

	public int getLowF() {
		return lowF;
	} 

	public void setLowF(int lowF) {
		this.lowF = lowF;
	}

}
