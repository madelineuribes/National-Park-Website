package com.techelevator.npgeek.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Model.Park.Park;
import com.techelevator.npgeek.Model.Park.ParkDao;
import com.techelevator.npgeek.Model.Survey.Survey;
import com.techelevator.npgeek.Model.Survey.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private ParkDao parkDao;

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String showSurveyInput(Model modelHolder) {
		List<Park> park = parkDao.getAllParks();
		modelHolder.addAttribute("allParks", park); 

		if (!modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		}
		return "survey"; 
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String processSurveyInput(@Valid @ModelAttribute Survey survey, BindingResult result,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			System.out.println("Errors");
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			flash.addFlashAttribute("survey", survey);
			return "redirect:/survey";
		}

		surveyDao.save(survey);

		return "redirect:/surveyResult";
	}

	@RequestMapping(path = "/surveyResult", method = RequestMethod.GET)
	public String showSurveyResult(ModelMap map) {

		List<Park> favPark = surveyDao.getNumOfSurveysTaken();
		map.addAttribute("favParks", favPark);
		
		return "surveyResult";
	}
}
