package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
