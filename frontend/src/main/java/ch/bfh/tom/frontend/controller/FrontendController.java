package ch.bfh.tom.frontend.controller;

import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

	private Camp selectedCamp;
	private String campName;

	@Autowired
	private FrontendService frontendService;

	@RequestMapping("/")
	public String home(Model model) {
		if(selectedCamp == null){
			Camp[] camps = frontendService.getCamps();
			model.addAttribute("camps", camps);
			model.addAttribute("campName", campName);
			return "selectCamp";
		}
		return "index";
	}

	@RequestMapping("/createCamp")
	public String createCamp(Model model, String campName) {
		//TODO: create a new camp
		return "index";
	}

	@GetMapping(value = "/battle")
	public String promoteFight(Model model) {
		String result = frontendService.promoteFight();
		model.addAttribute("result", result);
		/*Party party = frontendService.createParty("Party");
		model.addAttribute("result", party.getName());*/
		return "index";
	}
}
