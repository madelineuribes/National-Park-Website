package com.techelevator.npgeek.Model.Park;

import java.util.List;


public interface ParkDao {

	public List<Park> getAllParks();
	
	public Park getParkById(String parkId);
	
}
 