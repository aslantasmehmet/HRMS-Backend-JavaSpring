package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.HRMS.entities.concretes.Language;
import org.springframework.data.domain.Sort;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	
	List<Language> getByResume_Id(int resumeId);
	
	List<Language> getByResume_Id(int resumeId, Sort sort);
	
	

}
