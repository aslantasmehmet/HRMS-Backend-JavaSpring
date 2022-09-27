package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.UserActivation;

public interface UserActivationService extends EntitiyService<UserActivation> {
	
	 DataResult<List<UserActivation>> getByIsActivated(boolean isActivated);
	
	 DataResult<UserActivation>   getByCode (String code);
	 
	 DataResult<UserActivation> getAllByUserId(int userId);
	



}
