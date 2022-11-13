package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserConfirmationTypeService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserConfirmationTypeDao;
import kodlamaio.HRMS.entities.concretes.UserConfirmationType;

@Service
public class UserConfirmationTypeManager implements UserConfirmationTypeService{
	
	private UserConfirmationTypeDao userConfirmationTypeDao;
	
	@Autowired
	public UserConfirmationTypeManager(UserConfirmationTypeDao userConfirmationTypeDao) {
		this.userConfirmationTypeDao = userConfirmationTypeDao;
	}

	@Override
	public Result add(UserConfirmationType userConfirmationType) {
		
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay Tipi Eklendi.");
	}

	@Override
	public Result update(UserConfirmationType userConfirmationType) {
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay Tipi Güncellendi.");
		
	}

	@Override
	public Result delete(int id) {
		userConfirmationTypeDao.deleteById(id);
		return new SuccessResult("Onay Tipi Silindi.");
	}

	@Override
	public DataResult<List<UserConfirmationType>> getAll() {
		return new SuccessDataResult<List<UserConfirmationType>>(userConfirmationTypeDao.findAll());
	}

	@Override
	public DataResult<UserConfirmationType> getById(int id) {
		return new SuccessDataResult<UserConfirmationType>(userConfirmationTypeDao.getById(id));
	}

}
