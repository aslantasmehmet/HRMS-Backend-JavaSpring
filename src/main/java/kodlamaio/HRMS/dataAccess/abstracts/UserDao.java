package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.User;

public interface UserDao  extends JpaRepository<User, Integer>{
	
	List<User> getAllByEmail (String email);

}
