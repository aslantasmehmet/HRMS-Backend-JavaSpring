package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.UserConfirmationType;

public interface  UserConfirmationTypeDao extends JpaRepository<UserConfirmationType, Integer>{

}
