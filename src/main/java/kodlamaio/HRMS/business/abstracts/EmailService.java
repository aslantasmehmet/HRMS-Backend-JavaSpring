package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface EmailService {

	
	Result sendEmail(User user);
}
