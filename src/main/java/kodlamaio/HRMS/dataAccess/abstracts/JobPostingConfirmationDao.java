package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation, Integer> {
	
	JobPostingConfirmation getByJobPosting_Id(int jobPostingId);

}