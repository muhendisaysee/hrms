package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResTechnologyDao;
import kodlamaio.hrms.entities.concretes.ResTechnology;

@Service
public class ResTechnologyManager implements ResTechnologyService{

	private ResTechnologyDao resTechnologyDao;
	
	@Autowired
	public ResTechnologyManager(ResTechnologyDao resTechnologyDao) {
		super();
		this.resTechnologyDao = resTechnologyDao;
	}

	@Override
	public DataResult<List<ResTechnology>> getAll() {
		return new SuccessDataResult<List<ResTechnology>>(this.resTechnologyDao.findAll(), "Listed technology and programming language");
	}

	@Override
	public Result add(ResTechnology resTechnology) {
		this.resTechnologyDao.save(resTechnology);
		return new SuccessResult("Resume technology and programming languages are recorded");
	}

}
