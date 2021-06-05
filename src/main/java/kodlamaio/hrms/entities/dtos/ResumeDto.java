package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ResEducation;
import kodlamaio.hrms.entities.concretes.ResJobExperience;
import kodlamaio.hrms.entities.concretes.ResLanguage;
import kodlamaio.hrms.entities.concretes.ResTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	
	private Candidate candidate;
	
	private List<ResTechnology> resTechnologies;
	private List<ResLanguage> resLanguages;
	private List<ResJobExperience> resExperiences;
	private List<ResEducation> resEducations;
	
}
