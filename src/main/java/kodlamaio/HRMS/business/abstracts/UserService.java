package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add (User user);
	
	Result delete (User user);
	
	DataResult<User> findByEmail(String email);
	
	DataResult<User> getById (int id);
	

}
