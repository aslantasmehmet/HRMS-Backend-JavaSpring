package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Education;
import org.springframework.data.domain.Sort;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
	
	List<Education> getByResume_Id(int resumeId);
	
	List<Education> getByResume_Id(int resumeId, Sort sort);

}
