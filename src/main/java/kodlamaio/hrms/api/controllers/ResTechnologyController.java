package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResTechnology;

@RestController
@RequestMapping("/api/technologies")
public class ResTechnologyController {
	
	private ResTechnologyService resTechnologyService;

	@Autowired
	public ResTechnologyController(ResTechnologyService resTechnologyService) {
		super();
		this.resTechnologyService = resTechnologyService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ResTechnology>> getAll(){
		return this.resTechnologyService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody ResTechnology resTechnology) {
		return this.resTechnologyService.add(resTechnology);
	}
		
}
