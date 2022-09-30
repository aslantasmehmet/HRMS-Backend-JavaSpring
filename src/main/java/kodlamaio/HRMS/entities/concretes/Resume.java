package kodlamaio.HRMS.entities.concretes;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@Column(name="id")
	private int id;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="resume_name")
	private String resumeName;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;
	
	@Column(name="last_updated_date")
	private LocalDateTime lastUpdatedDate;
	
	@Column(name="visibilty")
	private String visibilty;
	
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<WorkExperience> workExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Education> educations;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Skill> skills;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="summary_information_id")
	private SummaryInformation summaryInformation;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="cover_letter_id")
	private CoverLetter coverLetter;
	
	public Resume(Candidate candidate) {
		this.setCandidate(candidate);
		
	}
	
	
	

}
