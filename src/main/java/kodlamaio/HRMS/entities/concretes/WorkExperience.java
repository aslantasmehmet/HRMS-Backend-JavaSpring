package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="work_experiences")

public class WorkExperience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	@NotNull
	private String companyName;
	
	@Column(name="company_sector")
	@NotNull
	private String companySector;
	
	@Column(name="position")
	@NotNull
	private String position;
	
	@Column(name="starting_date")
	@NotNull
	private LocalDate startingDate;
	
	@Column(name="end_date")
	@NotNull
	private LocalDate endDate;
	
	@Column(name="working_type")
	@NotNull
	private String workingType;

	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	public String getEndDate(){
		if(endDate == null) {
			return "Devam Ediyor";
		}
		return endDate.toString();
	}
	
	
	

	

}
