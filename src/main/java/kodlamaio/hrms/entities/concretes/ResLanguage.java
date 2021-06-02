package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private char langLevel;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume; 
}
	

