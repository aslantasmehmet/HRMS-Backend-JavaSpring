package kodlamaio.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailService;
import kodlamaio.HRMS.business.abstracts.UserConfirmationService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserConfirmationDao;
import kodlamaio.HRMS.entities.concretes.UserConfirmation;

@Service
public class UserConfirmationManager implements UserConfirmationService {
	
	private UserConfirmationDao userConfirmationDao;
	private EmailService emailService;

	public UserConfirmationManager(
			UserConfirmationDao userConfirmationDao,
			EmailService emailService
			) {
		super();
		this.userConfirmationDao = userConfirmationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(UserConfirmation userConfirmation) {
		userConfirmation.setIsConfirmedDate(LocalDateTime.now());
		
		userConfirmationDao.save(userConfirmation);
		emailService.sendEmail(userConfirmation.getUser());
		return new SuccessResult();
		
		
	}

	@Override
	public Result update(UserConfirmation userConfirmation) {
		
		userConfirmationDao.save(userConfirmation);
		return new SuccessResult();
		
	}

	@Override
	public Result delete(int id) {
		userConfirmationDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<UserConfirmation>> getAll() {
		return new SuccessDataResult<>(this.userConfirmationDao.findAll());
	}

	@Override
	public DataResult<UserConfirmation> getById(int id) {
		return new SuccessDataResult<>(this.userConfirmationDao.getById(id));
	}

	@Override
	public DataResult<List<UserConfirmation>> getByIsConfirmedAndUserConfirmationType_Id(boolean isConfirmed,
			int userConfirmationTypeId) {
		return new SuccessDataResult<>(this.userConfirmationDao.getByIsConfirmedAndUserConfirmationType_Id(isConfirmed, userConfirmationTypeId));
	}

	@Override
	public DataResult<List<UserConfirmation>> getAllByUserId(int userId) {
		return new SuccessDataResult<>(this.userConfirmationDao.getByUser_Id(userId));
	}

}
