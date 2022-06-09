package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.business.BusinessRules;
import kodlamaio.HRMS.core.utilities.business.validation.TaxNumverValidation.TaxNumberValidation;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.ErrorResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"Tüm İşverenler Listelendi.");
	}
	
	@Override
	public DataResult<Employer> getByUserId(int userId) {
		return new SuccessDataResult<Employer>(this.employerDao.getByUserId(userId),
				"Id Numara Sırasına Göre İşverenler Listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		var result = BusinessRules.run(
				CheckIfTheEmailIsRegistered(employer),
				CheckIfTheTaxNumber(employer),
				isRealEmail(employer),
				TaxNumberValidation(employer)
				);
		if(result !=null) {
			return result;
			}
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt Olma İşlemi Başarılı");
	}

	private Result CheckIfTheEmailIsRegistered(Employer employer) {
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() !=0) {
			return new ErrorResult("'" + employer.getEmail() + "'" + "Adresiyle Daha Önce Hesap Açılmış");
		}
		return new SuccessResult();
	}
	
	private Result CheckIfTheTaxNumber(Employer employer) {
		if(employerDao.findAllByTaxNumber(employer.getTaxNumber()).stream().count() !=0) {
			return new ErrorResult("'" + employer.getTaxNumber() + "'" + "Vergi Numarası ile  Daha Önce Hesap Açılmış");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmail(Employer employer) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(!matcher.matches()) {
			return new ErrorResult("Hatalı Mail Adresi Girdiniz.");
		}
		return new SuccessResult();
	}
	
	private Result TaxNumberValidation(Employer employer) {
		if(!TaxNumberValidation.isRealPerson(employer.getTaxNumber())) {
			return new ErrorResult("Vergi Numarası Doğrulanamadı");
		}
		return new SuccessResult();
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("İşveren Silme İşlemi Başarılı.");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren kullanıcı bilgileri güncellendi.");
	}

}
