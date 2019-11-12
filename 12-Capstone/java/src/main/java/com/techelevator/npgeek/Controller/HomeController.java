package com.techelevator.npgeek.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.Model.Park;
import com.techelevator.npgeek.Model.ParkDao;

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
}
