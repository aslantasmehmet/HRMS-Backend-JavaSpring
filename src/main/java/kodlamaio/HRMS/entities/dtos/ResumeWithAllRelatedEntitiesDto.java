package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.CoverLetter;
import kodlamaio.HRMS.entities.concretes.Education;
import kodlamaio.HRMS.entities.concretes.Language;
import kodlamaio.HRMS.entities.concretes.Skill;
import kodlamaio.HRMS.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWithAllRelatedEntitiesDto {
	

	private int id;

	private LocalDateTime creationDate;

	private Candidate candidate;

	private CoverLetter coverLetter;



	private List<Education> educations;

	private List<WorkExperience> workExperiences;

	private List<Language> languages;

	private List<Skill> skills;
	

}
