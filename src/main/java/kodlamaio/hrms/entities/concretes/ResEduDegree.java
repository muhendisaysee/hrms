package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "resume_edu_degree")
@AllArgsConstructor
@NoArgsConstructor
public class ResEduDegree {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
//	@OneToMany(mappedBy = "resEducation")
//	private List<ResEducation> resEducation;
	
	
}
