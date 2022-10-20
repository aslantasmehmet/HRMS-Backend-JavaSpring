package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="summary_informations")
public class SummaryInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="gender")
	@NotNull
	private int gender;
	
	@Column(name="nationality")
	@NotNull
	private String nationality;
	
	@Column(name="military_status")
	@NotNull
	private String militaryStatus;
	
	@Column(name="postponement_date")
	@NotNull
	private LocalDate postponementDate;
	
	@Column(name="driving_license_class")
	@NotNull
	private String drivingLicenseClass;
	
	@Column(name="net_salary_expectation")
	@NotNull
	private String netSalaryExpectation;
	
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@OneToOne(mappedBy = "coverLetter")
	private Resume resume;
	
	

}
