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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_language")
@AllArgsConstructor
@NoArgsConstructor
public class ResLanguage {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "lang_level")
	private int langLevel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume; 
	
}
	

