package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.UserActivation;

public interface UserActivationService extends EntitiyService<UserActivation> {
	
	 DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated);
	
	 DataResult<UserActivation>   getByCode (String code);
	 
	 DataResult<UserActivation> getByUserId(int userId);
	 
	



}
