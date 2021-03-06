package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResJobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResJobExperience;

@RestController
@RequestMapping("/api/jobExperience")
@CrossOrigin
public class ResJobExperienceController {
	
	private ResJobExperinceService resJobExperienceService;
	
	@Autowired
	public ResJobExperienceController(ResJobExperinceService resJobExperienceService) {
		super();
		this.resJobExperienceService = resJobExperienceService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ResJobExperience>> getAll(){
		return this.resJobExperienceService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody ResJobExperience resJobExperience) {
		return this.resJobExperienceService.add(resJobExperience);
	}
	@GetMapping("/getAllJobExperiencesDesc")
	public DataResult<List<ResJobExperience>> getAllSorted(){
		return this.resJobExperienceService.getAllSorted();
	}
}
