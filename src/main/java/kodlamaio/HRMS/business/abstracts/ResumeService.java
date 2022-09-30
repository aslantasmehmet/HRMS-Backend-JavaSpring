package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.Resume;

public interface ResumeService extends EntitiyService<Resume> {
	
	DataResult<Resume> getByCandidateId(int candidateId);
	

	
	


}
