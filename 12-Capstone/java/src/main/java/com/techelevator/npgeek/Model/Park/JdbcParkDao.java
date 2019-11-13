package com.techelevator.npgeek.Model.Park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcParkDao implements ParkDao{ 
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}  
 
	@Override
	public Park getParkById(String parkId) {
		Park park = new Park();
		String sqlSelectParkById = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkById, parkId);
		if(results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkcode"));    
		park.setName(results.getString("parkname")); 
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevation(results.getInt("elevationinfeet"));
		park.setMilesOfTrail(results.getDouble("milesoftrail"));
		park.setNumOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setInspQuote(results.getString("inspirationalquote"));
		park.setInspQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return park; 
	}
	
}
