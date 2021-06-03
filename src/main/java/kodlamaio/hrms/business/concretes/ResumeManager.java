package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapter.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.var;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "Listed all resume");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Resume is recorded");
	}

	@Override
	public Result upload(int resumeId, MultipartFile file) throws IOException {
			Map result=cloudinaryService.upload(file);
	        Resume resume=resumeDao.getOne(resumeId);
	        resume.setPhoto(result.get("url").toString());
	        resumeDao.save(resume);
	        return new SuccessResult("İşlem başarılı");
	}



}
