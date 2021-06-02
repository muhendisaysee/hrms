package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResEduDegreeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResEduDegree;

@RestController
@RequestMapping("/api/educationDegree")
public class ResEduDegreeController {
	
	private ResEduDegreeService resEduDegreeService;

	@Autowired
	public ResEduDegreeController(ResEduDegreeService resEduDegreeService) {
		super();
		this.resEduDegreeService = resEduDegreeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ResEduDegree>> getAll(){
		return this.resEduDegreeService.getAll();
	}
	@PostMapping("/add")
	public Result add(ResEduDegree resEduDegree) {
		return this.resEduDegreeService.add(resEduDegree);
	}
	
}
