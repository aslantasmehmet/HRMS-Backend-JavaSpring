package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{
	
	
	List<WorkExperience> getByResume_Id(int resumeId);
	
	List<WorkExperience> getByResume_Id(int resumeId, Sort sort);
}
