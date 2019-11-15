package com.techelevator.npgeek.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Model.Park.Park;
import com.techelevator.npgeek.Model.Park.ParkDao;
import com.techelevator.npgeek.Model.Survey.Survey;
import com.techelevator.npgeek.Model.Weather.Weather;
import com.techelevator.npgeek.Model.Weather.WeatherDao;

@Controller
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping("/")
	public String displayHomePage(ModelMap modelMap) {
		List<Park> park = parkDao.getAllParks();
		modelMap.put("allParks", park); 
		return "homePage"; 
	}

	@RequestMapping("/parkDetail")
	public String displayParkDetail(@RequestParam String parkCode, ModelMap models) {
		models.put("allWeather", weatherDao.getWeatherById(parkCode));
		models.put("park", parkDao.getParkById(parkCode));
		return "parkDetail"; 
	}

<<<<<<< HEAD
	
=======
>>>>>>> 7d873a862c6587c970b456f16effae1f7833ce0e
	@RequestMapping(path = "/parkDetail", method = RequestMethod.POST)
	public String changeTemperatureFC(@RequestParam String tempFC, 
			@RequestParam String parkCode,HttpSession session) {
	    if (tempFC.equals("Celsius")) {
	        Boolean celcius = true;
	        session.setAttribute("celcius", celcius);
	    } else {
	        Boolean celcius = false;
	        session.setAttribute("celcius", celcius);
	    }
	    return "redirect:/parkDetail?parkCode=" + parkCode;
	}
<<<<<<< HEAD

=======
>>>>>>> 7d873a862c6587c970b456f16effae1f7833ce0e

}
