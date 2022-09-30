package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailService;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult(user.getEmail()+" adresine e-posta gönderildi.");
	}

}
