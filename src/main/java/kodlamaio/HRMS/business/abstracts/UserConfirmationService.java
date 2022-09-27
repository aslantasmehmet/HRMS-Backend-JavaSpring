package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.UserConfirmation;

public interface UserConfirmationService extends EntitiyService<UserConfirmation> {
	
	
	DataResult<List<UserConfirmation>> getByIsConfirmedAndUserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);
	
	
	DataResult<List<UserConfirmation> > getAllByUserId(int userId);

}
