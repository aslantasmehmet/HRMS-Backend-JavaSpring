package kodlamaio.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.business.abstracts.UserActivationService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.mernis.UserCheckService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.ErrorResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Resume;
import kodlamaio.HRMS.entities.concretes.UserActivation;

@Service
public class CandidateManager implements CandidateService{
	
	private  CandidateDao candidateDao;
	private UserActivationService userActivationService;
	private UserService userService;
	private ResumeService resumeService;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(
			CandidateDao candidateDao,
			UserActivationService userActivationService,
			UserService userService,
			ResumeService resumeService,
			UserCheckService userCheckService
			) {
		super();
		this.candidateDao = candidateDao;
		this.userActivationService = userActivationService;
		this.userService = userService;
		this.resumeService = resumeService;
		this.userCheckService = userCheckService;
	}


	@Override
	public Result add(Candidate candidate) {
		
		if(validateCandidate(candidate) !=null) {
			return validateCandidate(candidate);
		}
		
		candidateDao.save(candidate);
		resumeService.add(new Resume(candidate));
		return userActivationService.add(new UserActivation(candidate));
	}
		
	
	
	@Override
	public Result update(Candidate entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result delete(int id) {
		candidateDao.deleteById(id);
		return new SuccessResult(
				"İş Arayan Silindi.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<>(this.candidateDao.findAll(),
				"Tüm Adaylar Listelendi.");
	}



	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<>(this.candidateDao.getByIdentityNumber(identityNumber)
				,"Kimlik Numarasına Göre  Adaylar Listelendi.");
	}


	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<>(this.candidateDao.getById(id)); 
	}



	@Override
	public Result activate(String code) {
		UserActivation userActivation = userActivationService.getByCode(code).getData();
		
		if(userActivation == null) {
			return new ErrorResult("Geçersiz Bir Kod Girdiniz.");
		}
		
		Candidate candidate = getById(userActivation.getUser().getId()).getData();
		userActivation.setActivated(true);
		userActivation.setIsActivatedDate(LocalDateTime.now());
		
		candidateDao.save(candidate);
		userActivationService.update(userActivation);
		return new SuccessResult("Üyelik İşlemleri Tamamlanmıştır.");
	}
	
	
	private boolean checkIfIdentityNumberExists(String identityNumber) {
		boolean result =false;
		
		
		if(getByIdentityNumber(identityNumber).getData()==null) {
			result = true;
		}
		return result;
	}
	
	private boolean checkIfEmailExists(String email) {
		boolean result = false;
		
		if(userService.getByEmail(email).getData()==null) {
			result = true;
		}
		return result;
	}
	
	private Result validateCandidate(Candidate candidate) {
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Girilen E-posta başka hesaba aittir.");
		}
		
		if(!checkIfIdentityNumberExists(candidate.getIdentityNumber())) {
			return new ErrorResult("Girilen Kimlik numarası başka bir hesaba aittir.");
		}
		
		if(!userCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth())) {
			return new ErrorResult("Lütfen Bilgilerinizi Doğru giriniz.");
		}
		return null;
	}

}
