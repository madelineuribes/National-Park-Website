package com.techelevator.npgeek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.Model.Survey.Survey;
import com.techelevator.npgeek.Model.Survey.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDao surveyDao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showSurveyInput() {
		
		return "survey";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String processSurveyInput(Survey survey) {

		// here we do something useful with the survey object
		surveyDao.save(survey);

		return "redirect:/surveyResult";
	}

	@RequestMapping(path = "/surveyResult", method = RequestMethod.GET)
	public String showSurveyResult(ModelMap map) {

		Survey survey = surveyDao.getSurvey();
		map.addAttribute("survey", survey);

		return "surveyResult";
	}
}
