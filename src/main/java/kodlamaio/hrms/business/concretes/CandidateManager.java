package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapter.EMailCheckService;
import kodlamaio.hrms.adapter.MernisService;
import kodlamaio.hrms.adapter.MernisServiceAdapter;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.Data;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private MernisService mernisService;
	private EMailCheckService emailCheckService;

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService,
			EMailCheckService emailCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "List candidates");
	}

	@Override
	public Result add(Candidate candidate){
	
		if(mernisService.checkIfReelPerson(candidate)) {
			if(emailCheckService.sendMail(candidate)) {
				if(emailCheckService.verificationCheckControl(candidate)) {
					if(this.candidateDao.findByEmailEquals(candidate.getEmail()).isEmpty() && this.candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber()).isEmpty()) {
						this.candidateDao.save(candidate);
						return new SuccessResult("add candidate");
					}
				}
			}
		}
		else {
			return new ErrorResult("Not Reel Person!");
			}
		return new ErrorResult("operation failed !");
	}


}
