package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.Education;

public interface EducationService extends EntitiyService<Education> {
	
	
	
	DataResult<List<Education>> getAllByResumeId (int resumeId);
	
	DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate (int resumeId);

}
