package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.UpdatedEmployer;

public interface UpdatedEmployerDao extends JpaRepository<UpdatedEmployer, Integer> {

	UpdatedEmployer getByEmployer_Id(int employerId);

}