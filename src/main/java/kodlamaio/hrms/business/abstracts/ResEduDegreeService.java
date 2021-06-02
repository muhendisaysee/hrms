package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResEduDegree;

public interface ResEduDegreeService {
	DataResult<List<ResEduDegree>> getAll();
	Result add(ResEduDegree resEduDegree);
}
