package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResEducation;

public interface ResEducationService {
	DataResult<List<ResEducation>> getAll();
	Result add(ResEducation resEducation);
	DataResult<List<ResEducation>> getAllSorted();
}
