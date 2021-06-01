package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping("/getAllEmployersJobAdvert")
	public DataResult<List<JobAdvertisement>> getByStatusAndEmployer_Id(@RequestParam boolean status,@RequestParam int employerId){
		return this.jobAdvertisementService.getByStatusAndEmployer_Id(status,employerId);
	}
	@GetMapping("/getAllTrueAdvert")
	public DataResult<List<JobAdvertisement>> getByStatusTrue(){
		return this.jobAdvertisementService.getByStatusTrue();
	}
	@GetMapping("/getJobAdvertByAsc")
	public DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByDeadlineAsc(){
		return this.jobAdvertisementService.findAllByStatusTrueOrderByDeadlineAsc();
	}

}
