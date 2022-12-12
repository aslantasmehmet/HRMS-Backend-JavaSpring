package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	List<Employer> getByUserActivation_IsActivated(boolean isActivated);
	
	List<Employer> getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);
	
	List<Employer> getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId, Sort sort);

}
