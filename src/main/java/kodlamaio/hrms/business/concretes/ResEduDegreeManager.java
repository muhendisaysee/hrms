package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResEduDegreeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResEduDegreeDao;
import kodlamaio.hrms.entities.concretes.ResEduDegree;

@Service
public class ResEduDegreeManager implements ResEduDegreeService{
	
	private ResEduDegreeDao resEduDegreeDao;
	
	@Autowired
	public ResEduDegreeManager(ResEduDegreeDao resEduDegreeDao) {
		super();
		this.resEduDegreeDao = resEduDegreeDao;
	}

	@Override
	public DataResult<List<ResEduDegree>> getAll() {
		return new SuccessDataResult<List<ResEduDegree>>(this.resEduDegreeDao.findAll(), "Listed Education degree");
	}

	@Override
	public Result add(ResEduDegree resEduDegree) {
		this.resEduDegreeDao.save(resEduDegree);
		return new SuccessResult("Recorded resume education degree");
	}

}
