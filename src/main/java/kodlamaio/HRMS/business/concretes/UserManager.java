package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getById(int userId) {
		return new SuccessDataResult<>(this.userDao.getById(userId));
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<>(this.userDao.getByEmail(email));
	}

}
