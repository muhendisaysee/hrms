package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_job_experience")
@AllArgsConstructor
@NoArgsConstructor
public class ResJobExperience {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "started_date")
	private Date startedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ended_date")
	private Date endedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume; 
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle; 
	
}
