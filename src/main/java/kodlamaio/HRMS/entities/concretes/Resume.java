package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="resumes")


public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="resume_name")
	private String resumeName;
	
	@Column(name="visibilty")
	private String visibilty;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@Column(name="last_updated_date")
	private LocalDate lastUpdatedDate;
	
	
	

}
