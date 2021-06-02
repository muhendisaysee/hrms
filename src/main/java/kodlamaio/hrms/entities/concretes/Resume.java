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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes")
public class Resume {
	
	@Id
	@GeneratedValue
	@Column(name = "resume_id")
	private int id;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedln_link")
	private String linkedlnLink;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private Date createdDate;
	
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
}
