package kodlamaio.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailService;
import kodlamaio.HRMS.business.abstracts.UserActivationService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserActivationDao;
import kodlamaio.HRMS.entities.concretes.UserActivation;

@Service
public class UserActivationManager implements UserActivationService{
	
	
	private UserActivationDao userActivationDao;
	private EmailService emailService;

	public UserActivationManager(
			UserActivationDao userActivationDao,
			EmailService emailService) {
		super();
		this.userActivationDao = userActivationDao;
		this.emailService = emailService;
	}
	
	
	@Override
	public Result add(UserActivation userActivation) {
		userActivation.setActivated(false);
		userActivation.setCode(generateCode());
		userActivation.setIsActivatedDate(LocalDateTime.now());
		
		
		userActivationDao.save(userActivation);
		return emailService.sendEmail(userActivation.getUser());
	}

	@Override
	public Result update(UserActivation userActivation) {
		userActivationDao.save(userActivation);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		userActivationDao.deleteById(id);
		return new SuccessResult("Id Numarasına göre Kullanıcı Silindi.");
	}


	@Override
	public DataResult<List<UserActivation>> getByIsActivated(boolean isActivated) {
		return new SuccessDataResult<>(this.userActivationDao.getByIsActivated(isActivated));
	}

	@Override
	public DataResult<UserActivation> getByCode(String code) {
		return new SuccessDataResult<>(this.userActivationDao.getByCode(code));
	}


	@Override
	public DataResult<List<UserActivation>> getAll() {
		return new SuccessDataResult<>(this.userActivationDao.findAll());

	
	}
	@Override
	public DataResult<UserActivation> getById(int id) {
		return new SuccessDataResult<>(this.userActivationDao.getById(id));
	}



	@Override
	public DataResult<UserActivation> getAllByUserId(int userId) {
		return new SuccessDataResult<>(this.userActivationDao.getByUser_Id(userId));
	}	
	
	private String generateCode() {
		UUID code = UUID.randomUUID();
		return code.toString();
	}

}
	
