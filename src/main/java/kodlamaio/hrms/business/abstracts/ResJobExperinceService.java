package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResJobExperience;

public interface ResJobExperinceService {
	DataResult<List<ResJobExperience>> getAll();
	Result add(ResJobExperience resJobExperience);
	DataResult<List<ResJobExperience>> getAllSorted();
	
}
