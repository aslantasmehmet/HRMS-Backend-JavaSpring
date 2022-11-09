package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkExperience;

public interface WorkExperienceService extends EntitiyService<WorkExperience> {
	
	DataResult<WorkExperience> getAllResumeId(int resumeId);
	
	DataResult<List<WorkExperience>> getAllByResumeIdSortedByTerminationDate(int resumeId);

}
