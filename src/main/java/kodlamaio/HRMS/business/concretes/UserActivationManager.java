package kodlamaio.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
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
	public DataResult<List<UserActivation>> getAll() {
		return new SuccessDataResult<List<UserActivation>>(userActivationDao.findAll());
	
	}

	@Override
	public DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated) {
		return new SuccessDataResult<List<UserActivation>>(userActivationDao.getByIsActivated(isActivated));
	}

	@Override
	public DataResult<UserActivation> getByCode(String code) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getByCode(code));
	}


	
	@Override
	public DataResult<UserActivation> getById(int id) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getById(id));
	}
	
	
	private String generateCode() {
		UUID code = UUID.randomUUID();
		return code.toString();
	}


	@Override
	public DataResult<UserActivation> getByUserId(int userId) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getByUser_Id(userId));
	}


	

}
	
