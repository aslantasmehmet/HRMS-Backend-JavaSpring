package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.User;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<User> findAllByEmail(String email);
	
	List<Employer> findAllByTaxNumber (String taxNumber);
	
	Employer getByUserId (int userId);

}
