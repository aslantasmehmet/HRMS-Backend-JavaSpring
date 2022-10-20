package kodlamaio.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{
	
	List<CoverLetter> getByCandidate_Id (int candidateId);
	
}
