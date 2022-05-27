package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.EmailVerification;

public interface EmailVerificationService {
	
	void generateCode (EmailVerification code, Integer id);
	Result verify(String verificationCode, Integer id);
}
