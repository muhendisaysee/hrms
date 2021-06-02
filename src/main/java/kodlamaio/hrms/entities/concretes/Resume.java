package kodlamaio.hrms.entities.concretes;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes")

public class Resume {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedln_link")
	private String linkedlnLink;
	
	@Column(name = "description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate; 
	
	@OneToMany(mappedBy = "resume")
	private List<ResTechnology> resTechnology;
	
	@OneToMany(mappedBy = "resume")
	private List<ResLanguage> resLanguage;
	
	@OneToMany(mappedBy = "resume")
	private List<ResEducation> resEducation;
	
	@OneToMany(mappedBy = "resume")
	private List<ResJobExperience> resJobExperience;
	
}
