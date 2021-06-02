package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResTechnology;

public interface ResTechnologyDao extends JpaRepository<ResTechnology, Integer>{

}
