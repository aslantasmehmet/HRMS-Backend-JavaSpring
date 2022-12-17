package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationService extends EntitiyService<JobPostingConfirmation> {
	
	DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId);

}
