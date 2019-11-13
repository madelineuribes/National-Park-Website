package com.techelevator.npgeek.Model.Survey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
 

	@Override
	public void save(Survey survey) { 
	    String insertSql = "INSERT INTO survey_result (parkcode, emailaddress, state, " +
	            "activitylevel) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(insertSql, survey.getParkCode(), survey.getEmail(), 
	            survey.getState(), survey.getActivityLevel()); 
	}
  
	@Override 
	public Survey getSurvey() {

	    Survey survey = new Survey();
	    String selectSql = "SELECT * " + 
	            "FROM survey_result";
	    
	    SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
	    
	    if (results.next()) {
	        survey.setParkCode(results.getString("parkcode"));
	        survey.setEmail(results.getString("emailaddress"));
	        survey.setState(results.getString("state"));
	        survey.setActivityLevel(results.getString("activitylevel"));
	    }

	    return survey;
	}
}
