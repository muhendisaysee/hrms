package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "open_position")
	private int openPosition;
	
	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer; 
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city; 
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle; 
}
