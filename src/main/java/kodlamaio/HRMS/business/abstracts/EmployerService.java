package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Employer;


public interface EmployerService extends EntitiyService<Employer> {

	Result activate(String code);

	Result confirm(int employerId, int companyStaffId, int userConfirmationTypeId, boolean isConfirmed);
	
	DataResult<List<Employer>> getAllOnesThatWaitingForAccountConfirmation();
	
	DataResult<List<Employer>> getAllOnesThatWaitingForUpdateConfirmation();
	
	DataResult<List<Employer>> getAllByIsActivated(boolean isActivated);
	
	DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);
	
	DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName(boolean isConfirmed, int userConfirmationTypeId);
	
	DataResult<Employer> getOneThatWaitingForUpdateConfirmationById(int id);
	
}
