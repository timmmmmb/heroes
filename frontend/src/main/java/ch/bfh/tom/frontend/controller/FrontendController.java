package ch.bfh.tom.frontend.controller;

import ch.bfh.tom.frontend.model.Party;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

	@Autowired
	private FrontendService frontendService;

	@RequestMapping("/")
	public String home(Model model) {
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
