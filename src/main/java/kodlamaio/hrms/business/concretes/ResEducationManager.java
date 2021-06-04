package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResEducationDao;
import kodlamaio.hrms.entities.concretes.ResEducation;

@Service
public class ResEducationManager implements ResEducationService{
	
	private ResEducationDao resEducationDao;
	
	@Autowired
	public ResEducationManager(ResEducationDao resEducationDao) {
		super();
		this.resEducationDao = resEducationDao;
	}

	@Override
	public DataResult<List<ResEducation>> getAll() {
		return new SuccessDataResult<List<ResEducation>>(this.resEducationDao.findAll(), "Listed resume educations");
	}

	@Override
	public Result add(ResEducation resEducation) {
		this.resEducationDao.save(resEducation);
		return new SuccessResult("Recorded resume education");
	}

	@Override
	public DataResult<List<ResEducation>> getAllSorted() {

		Sort sort = Sort.by(Sort.Direction.DESC, "endedDate");
		return new SuccessDataResult<List<ResEducation>>( this.resEducationDao.findAll(sort),"Başarılı");
	}	



}
