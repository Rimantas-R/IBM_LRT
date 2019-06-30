package lt.r.lrtlive.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lt.r.lrtlive.models.LiveItem;
import lt.r.lrtlive.services.ParserService;

@Controller
public class MainController {

	@Autowired
	ParserService service;
	
	@GetMapping(value="/lrtnow")
	@ResponseBody
	List<LiveItem> getLrtNow(){
		List<LiveItem> broadcastNow = new ArrayList<>();
		try {
			broadcastNow = service.stoutP();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return broadcastNow;
	}
	
	@GetMapping(value="/lrtnowhtml")
	String getPretty(Model model) {
		model.addAttribute("channels",getLrtNow());
		return "streamingnow";
	}
	
}
