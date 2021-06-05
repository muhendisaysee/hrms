package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumeController {
	
	private ResumeService resumeService;
	
	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume)  {
		return this.resumeService.add(resume);
	}
	@PostMapping("/uploadPhoto")
	public Result addImage(@RequestParam int resumeId, @RequestParam("file") MultipartFile file) throws IOException{
		return resumeService.upload(resumeId, file);
	}
	@GetMapping("/getCvForCandidateId")
	public DataResult<List<Resume>> getByResumeIdForCandidateId(@RequestParam int candidateId){
		return this.resumeService.getByResumeIdForCandidateId(candidateId);
	}

}
