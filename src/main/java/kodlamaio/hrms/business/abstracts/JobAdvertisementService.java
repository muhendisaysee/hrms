package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByStatusAndEmployer_Id(boolean status,int employerId);
	
	DataResult<List<JobAdvertisement>> getByStatusTrue();
	
	DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByDeadlineAsc();
	
	DataResult<JobAdvertisement> getByStatus(int jobAdvertisementId);
	
	
}
