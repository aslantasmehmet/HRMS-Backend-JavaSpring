package kodlamaio.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.SummaryInformation;

public interface SummaryInformationDao extends JpaRepository<SummaryInformation, Integer> {
	
	List<SummaryInformation> getByCandidate_Id (int candidateId);

	

}
