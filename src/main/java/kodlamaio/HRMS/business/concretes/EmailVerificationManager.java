package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailVerificationService;
import kodlamaio.HRMS.core.utilities.random.GenerateRandomCode;
import kodlamaio.HRMS.core.utilities.result.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.HRMS.entities.concretes.EmailVerification;

@Service
public class EmailVerificationManager implements EmailVerificationService {
 
	private EmailVerificationDao emailVerificationDao;

	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

	@Override
	public void generateCode(EmailVerification code, Integer id) {
		EmailVerification code_ = code;
							code_.setCode(null);
							code_.setVerified(false);
							if(code.isVerified()==false) {
									GenerateRandomCode generator = new GenerateRandomCode();
									String code_create = generator.create();
									code.setCode(code_create);
									code.setUserId(id);
									
									emailVerificationDao.save(code);
			
							}
							return;
	}

	@Override
	public Result verify(String verificationCode, Integer id) {
		EmailVerification ref = emailVerificationDao.getById(id);
		if(ref.getCode().equals(verificationCode)) {
			ref.setVerified(true);
			return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref),
					"Doğrulama Başarılı.");
		}
		return new ErrorDataResult<EmailVerification>(null,
				"Doğrulama Kodu Geçersiz.");
	}
	
	
	
}
