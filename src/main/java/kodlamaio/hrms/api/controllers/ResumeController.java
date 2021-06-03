package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapter.cloudinary.concretes.CloudinaryManager;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Resume;
import com.cloudinary.*;

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

	
}
