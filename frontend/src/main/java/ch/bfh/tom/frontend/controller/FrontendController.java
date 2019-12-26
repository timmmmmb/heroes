package ch.bfh.tom.frontend.controller;

import ch.bfh.tom.frontend.client.PromoterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

	@Autowired
	private PromoterClient promoterClient;

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@GetMapping(value = "/battle")
	public String promoteFight(Model model) {
		String result = promoterClient.promoteFight();
		model.addAttribute("result", result);
		return "index";
	}
}
