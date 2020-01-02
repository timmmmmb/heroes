package ch.bfh.tom.frontend.controller;

import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

	private Camp selectedCamp;

	@Autowired
	private FrontendService frontendService;

	@GetMapping("/")
	public String home(Model model) {
		if(selectedCamp == null){
			return "redirect:selectCamp";
		}
		return "index";
	}

	@GetMapping("/selectCamp")
	public String selectCamp(Model model, String campName) {
		Camp[] camps = frontendService.getCamps();
		model.addAttribute("camps", camps);
		model.addAttribute("campName", campName);
		return "selectCamp";
	}

	@GetMapping("/createCamp")
	public String createCamp(Model model, String campName) {
		selectedCamp = frontendService.createCamp(campName==null?"Name":campName);
		model.addAttribute("selectedCamp", selectedCamp);
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

	@GetMapping(value = "/changeCamp")
	public String changeCamp(Model model) {
		selectedCamp = null;
		return "redirect:selectCamp";
	}
}