package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPostingConfirmationType;

public interface JobPostingConfirmationTypeDao extends JpaRepository<JobPostingConfirmationType, Integer> {

}
