package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResLanguage;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class ResLanguageController {
	private ResLanguageService resLanguageService;
	
	@Autowired
	public ResLanguageController(ResLanguageService resLanguageService) {
		super();
		this.resLanguageService = resLanguageService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ResLanguage>> getAll(){
		return this.resLanguageService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody ResLanguage resLanguage) {
		return this.resLanguageService.add(resLanguage);
	}
	
}
