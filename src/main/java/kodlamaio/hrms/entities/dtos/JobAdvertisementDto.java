package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private String description;
	private int salaryMin;
	private int salaryMax;
	private int openPosition;
	private LocalDate deadline;
	private boolean status;
	private LocalDate releaseDate;
	private int employerId; 
	private int cityId; 
	private int jobTitleId; 
}
