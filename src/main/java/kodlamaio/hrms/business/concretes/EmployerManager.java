package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapter.EMailCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EMailCheckService emailCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EMailCheckService emailCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "list employer");
	}

	@Override
	public Result add(Employer employer) {
		if(this.employerDao.findByEmailEquals(employer.getEmail()).isEmpty()) {
			if(emailCheckService.sendMail(employer)) {
				if(emailCheckService.verificationCheckControl(employer)) {
					this.employerDao.save(employer);
					return new SuccessResult("add employer");
				}
			}
			
		}else {
			return new ErrorResult("Email recorded");
		}
		return new ErrorResult("Email not verification");
	}

}
