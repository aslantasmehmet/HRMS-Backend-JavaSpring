package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getByUserId (int userId);
	
	Result add(Employer employer);
	Result delete (Employer employer);
	Result update (Employer employer);
	
	

}
