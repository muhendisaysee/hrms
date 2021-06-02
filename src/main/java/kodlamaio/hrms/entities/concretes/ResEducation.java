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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "resume_edu")
@AllArgsConstructor
@NoArgsConstructor
public class ResEducation {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "ended_date")
	private Date endedDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume; 
	
	@ManyToOne(targetEntity = ResEduDegree.class)
	@JoinColumn(name = "graduate_id", referencedColumnName =  "id" ,nullable = false)
	private ResEduDegree resEduDegree; 
}
