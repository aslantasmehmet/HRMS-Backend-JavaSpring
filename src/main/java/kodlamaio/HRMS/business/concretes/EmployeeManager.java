package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployeeService;
import kodlamaio.HRMS.core.utilities.business.BusinessRules;
import kodlamaio.HRMS.core.utilities.business.validation.NationalityIdValidation;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.ErrorResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployeeDao;
import kodlamaio.HRMS.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	

	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),
				"Tüm İş Arayanlar Listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		var result = BusinessRules.run(
				CheckIfTheEmailIsRegistered(employee),
				CheckIfTheİdentificationNumber(employee),
				isRealEmail(employee),
				İdentificationNumberValidation(employee)
				);
		
		if(result != null) {
			return result;
		}
		
		this.employeeDao.save(employee);
		return new SuccessResult("Kayıt Olma İşlemi Başarılı");
	}
	
	private Result CheckIfTheEmailIsRegistered (Employee employee) {
		if(employeeDao.findAllByEmail(employee.getEmail()).stream().count() !=0) {
			return new ErrorResult("'" + employee.getEmail()+ "'"+ "Adresiyle daha önce Hesap Açılmış.");
		}
		return new SuccessResult();
	}

	private Result CheckIfTheİdentificationNumber(Employee employee) {
		if(employeeDao.findAllByİdentificationNumber(employee.getIdentificationNumber()).stream().count() !=0) {
			return new ErrorResult("'" + employee.getIdentificationNumber()+ "'" + "Bu Kimlik Numarası ile Daha önce Kayıt Olunmuştur.");
		}
		return new SuccessResult();
	}
	
	
	private Result isRealEmail (Employee employee) {
		 
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher  = pattern.matcher(employee.getEmail());
		if(!matcher.matches()) {
			return new ErrorResult("Hatalı Email Adresi giridiniz.");
			
		}
		return new SuccessResult();
	}
	private Result İdentificationNumberValidation(Employee employee) {
		if(!NationalityIdValidation.isRealPerson(employee.getIdentificationNumber())) {
			return new ErrorResult("Kimlik Doğrulanamadı");
		}
		return new SuccessResult();
	}
	
}
