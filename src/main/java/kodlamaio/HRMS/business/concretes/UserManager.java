package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.User;
import kodlamaio.HRMS.entities.dtos.UserLoginDto;
import kodlamaio.HRMS.entities.dtos.UserLoginReturnDto;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	private CandidateDao candidateDao;

	public UserManager(UserDao userDao,CandidateDao candidateDao) {
		super();
		this.userDao = userDao;
		this.candidateDao = candidateDao;
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
		return new SuccessDataResult<>(this.userDao.getByEmail(email),"Email'göre kişi getirilmiştir.");
	}


	@Override
	public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
		User user = this.userDao.getByEmail(userLoginDto.getEmail());
		
		if(user == null) {
			return new ErrorDataResult<UserLoginReturnDto>("Invalid E-mail!");
		}
		
		else if(!user.getPassword().equals(userLoginDto.getPassword())) {
			return new ErrorDataResult<UserLoginReturnDto>("Wrong Password is Entered!");
		}
		
		UserLoginReturnDto userLoginReturnDto =new UserLoginReturnDto();
		userLoginReturnDto.setId(user.getId());
		userLoginReturnDto.setEmail(user.getEmail());
		
		if(this.candidateDao.existsById(user.getId())) {
			userLoginReturnDto.setUserType(1);
			userLoginReturnDto.setName(this.candidateDao.getById(user.getId()).getFirstName() + " " +
			this.candidateDao.getById(user.getId()).getLastName());
			
		}else {
			return new ErrorDataResult<UserLoginReturnDto>("Something went wrong!");
		}
		return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto, "Successfully logined!");
	}
	

}
