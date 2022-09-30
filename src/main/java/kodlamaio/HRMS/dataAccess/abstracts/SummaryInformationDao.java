package kodlamaio.HRMS.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.SummaryInformation;

public interface SummaryInformationDao extends JpaRepository<SummaryInformation, Integer> {
	
	
	

}
