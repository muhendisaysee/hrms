package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "List candidates");
	}

	@Override
	public Result add(Candidate candidate) {
		System.out.println("ARADIĞIN ŞEY : "+candidateDao.findByEmailEquals(candidate.getEmail()));
		if(candidateDao.findByEmailEquals(candidate.getEmail())) {
			return new ErrorResult("Database has this email");
		}
		else if(candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber())) {
			return new ErrorResult("Database has this identity number");
		}
		else {
				this.candidateDao.save(candidate);
				return new SuccessResult("add candidate");
		}
	
	}

}