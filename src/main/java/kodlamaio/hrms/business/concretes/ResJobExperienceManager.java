package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResJobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResJobExperienceDao;
import kodlamaio.hrms.entities.concretes.ResJobExperience;

@Service
public class ResJobExperienceManager implements ResJobExperinceService{
	
	private ResJobExperienceDao resJobExperienceDao;
	
	@Autowired
	public ResJobExperienceManager(ResJobExperienceDao resJobExperienceDao) {
		super();
		this.resJobExperienceDao = resJobExperienceDao;
	}

	@Override
	public DataResult<List<ResJobExperience>> getAll() {
		return new SuccessDataResult<List<ResJobExperience>>(this.resJobExperienceDao.findAll(), "Listed resume job experiences");
	}
	@Override
	public Result add(ResJobExperience resJobExperience) {
		this.resJobExperienceDao.save(resJobExperience);
		return new SuccessResult("Recorded job experience");
	}
	@Override
	public DataResult<List<ResJobExperience>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endedDate");
		return new SuccessDataResult<List<ResJobExperience>>( this.resJobExperienceDao.findAll(sort),"Başarılı");
	}	


}
