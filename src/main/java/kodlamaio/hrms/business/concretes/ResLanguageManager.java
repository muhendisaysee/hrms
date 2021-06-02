package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResLanguageDao;
import kodlamaio.hrms.entities.concretes.ResLanguage;

@Service
public class ResLanguageManager implements ResLanguageService{

	private ResLanguageDao resLanguageDao;
	
	@Autowired
	public ResLanguageManager(ResLanguageDao resLanguageDao) {
		super();
		this.resLanguageDao = resLanguageDao;
	}

	@Override
	public DataResult<List<ResLanguage>> getAll() {
		return new SuccessDataResult<List<ResLanguage>>(this.resLanguageDao.findAll(), "Listed languages") ;
	}

	@Override
	public Result add(ResLanguage resLanguage) {
		this.resLanguageDao.save(resLanguage);
		return new SuccessResult("Recorded language");
	}

}
