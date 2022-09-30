package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll ();
	
	DataResult<User> getById (int id);
	
	DataResult<User> getByEmail(String email);

}
