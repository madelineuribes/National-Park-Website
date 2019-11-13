package com.techelevator.npgeek.Model.Survey;

import java.util.List;

import com.techelevator.npgeek.Model.Park.Park;

public interface SurveyDao {

	void save(Survey survey);

	Survey getSurvey();

	List<Park> getNumOfSurveysTaken();

}
