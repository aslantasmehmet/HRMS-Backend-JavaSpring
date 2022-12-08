package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Resume;
import kodlamaio.HRMS.entities.dtos.ResumeWithAllRelatedEntitiesDto;

public interface ResumeService extends EntitiyService<Resume> {
	

	Result addCoverLetterToResume(int resumeId, int coverLetterId);
	
	Result deleteCoverLetterFromResume(int resumeId);

	DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByActivatedCandidate();

	DataResult<Resume> getByCandidateId(int candidateId);

	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);


}
