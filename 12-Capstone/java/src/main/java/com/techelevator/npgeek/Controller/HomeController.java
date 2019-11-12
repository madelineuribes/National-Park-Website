package com.techelevator.npgeek.Controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Model.Park.Park;
import com.techelevator.npgeek.Model.Park.ParkDao;

@Controller
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@RequestMapping("/")
	public String displayHomePage(ModelMap modelMap) {
		List<Park> park = parkDao.getAllParks();
		modelMap.put("allParks", park);
		return "homePage";
	}

	@RequestMapping("/parkDetail")
	public String displayParkDetail(@RequestParam String parkCode, ModelMap models) {
		models.put("parkCode", parkCode);
		models.put("park", parkDao.getParkById(parkCode));
		return "parkDetail";
	}
}
