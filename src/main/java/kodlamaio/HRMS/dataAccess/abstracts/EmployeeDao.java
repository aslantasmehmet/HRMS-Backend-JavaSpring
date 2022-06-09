package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Employee;
import kodlamaio.HRMS.entities.concretes.User;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	List<User> findAllByEmail(String email);
	
	List<Employee> findAllByİdentificationNumber(String identificationNumber);

}
