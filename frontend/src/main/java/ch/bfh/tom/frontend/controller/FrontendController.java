package ch.bfh.tom.frontend.controller;

import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendController {

	private Camp selectedCamp;


	@Autowired
	private FrontendService frontendService;

	@GetMapping("/")
	public String home(Model model) {
		if(selectedCamp == null){
			return "redirect:campForm";
		}
		model.addAttribute("selectedCamp", selectedCamp);
		return "index";
	}

	@GetMapping("/index")
	public String index(Model model) {
		return "redirect:/";
	}

	@GetMapping("/campForm")
	public String campForm(Model model) {
		Camp[] camps = frontendService.getCamps();
		model.addAttribute("camps", camps);
		return "campForm";
	}

	@GetMapping("/selectCamp")
	public String selectCamp(Model model, @RequestParam String campID) {
		if(campID.equals(""))return "redirect:campForm";
		selectedCamp = frontendService.getCamp(campID);
		return "redirect:index";
	}

	@GetMapping("/createCamp")
	public String createCamp(Model model, @RequestParam String campName) {

		if(campName.equals("")){
			return "campForm";
		}
		selectedCamp = frontendService.createCamp(campName);
		model.addAttribute("selectedCamp", selectedCamp);
		return "redirect:index";
	}

	@GetMapping(value = "/battle")
	public String promoteFight(Model model) {
		String result = frontendService.promoteFight();
		model.addAttribute("selectedCamp", selectedCamp);
		model.addAttribute("result", result);
		return "index";
	}

	@GetMapping(value = "/changeCamp")
	public String changeCamp(Model model) {
		selectedCamp = null;
		return "redirect:selectCamp";
	}


	@GetMapping(value = "/manageHeroes")
	public String manageHeroes(Model model) {
		if(selectedCamp == null){
			return "redirect:campForm";
		}
		model.addAttribute("selectedCamp", selectedCamp);
		return "heroManager";
	}

	@GetMapping(value = "/addHero")
	public String addHero(Model model, @RequestParam String heroName) {
		if(selectedCamp == null){
			return "redirect:campForm";
		}
		if(heroName.equals("")){
			return "heroManager";
		}
		selectedCamp = frontendService.addHero(heroName, selectedCamp.getId());
		model.addAttribute("selectedCamp", selectedCamp);
		return "heroManager";
	}
}