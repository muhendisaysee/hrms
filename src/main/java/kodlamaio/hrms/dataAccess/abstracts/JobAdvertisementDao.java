package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	

	List<JobAdvertisement> getByStatusAndEmployer_Id(boolean status, int employerId);
	
	List<JobAdvertisement> getByStatusTrue();
	
	List<JobAdvertisement> findAllByStatusTrueOrderByDeadlineAsc();
	
	JobAdvertisement getByStatus(int jobAdvertisement_Id);
	
}
