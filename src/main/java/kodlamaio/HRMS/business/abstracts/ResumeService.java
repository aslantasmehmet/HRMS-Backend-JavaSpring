package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Resume;
import kodlamaio.HRMS.entities.dtos.ResumeWithAllRelatedEntitiesDto;

public interface ResumeService extends EntitiyService<Resume> {
	
	DataResult<Resume> getByCandidateId(int candidateId);
	
	Result deleteCoverLetterFromResume (int resumeId);
	
	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);
	

	DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumeDetailsByCandidate();
	


}
