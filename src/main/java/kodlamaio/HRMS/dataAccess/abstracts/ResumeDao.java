package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	
	Resume getByCandidate_Id(int candidateId );
	
	Resume getByCoverLetter_Id(int  coverLetterId);
	
	Resume getBySummaryInformation_Id (int summaryInformationId);

}
