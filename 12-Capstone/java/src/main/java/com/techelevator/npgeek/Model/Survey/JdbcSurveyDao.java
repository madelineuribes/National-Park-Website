package com.techelevator.npgeek.Model.Survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Model.Park.Park;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey survey) {
		String insertSql = "INSERT INTO survey_result (parkcode, emailaddress, state, "
				+ "activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, survey.getParkCode(), survey.getEmail(), survey.getState(),
				survey.getActivityLevel());
	}

	@Override
	public List<Park> getNumOfSurveysTaken() {
		List<Park> parkList = new ArrayList<>();
		String getSurveyNumberSql = "SELECT survey_result.parkcode, parkname, park.state,\r\n" + 
				"count(survey_result.parkcode) AS surveycount FROM survey_result \r\n" + 
				"JOIN park ON park.parkcode = survey_result.parkcode \r\n" + 
				"GROUP BY survey_result.parkcode, parkname, park.state ORDER BY surveycount DESC, parkname ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getSurveyNumberSql);
		
		while(results.next()) {
			Park tempPark = new Park();
			tempPark.setName(results.getString("parkname"));
			tempPark.setState(results.getString("state"));
			tempPark.setSurveyCount(results.getInt("surveycount"));
			parkList.add(tempPark);
		}
		
		return parkList;
	}

}
