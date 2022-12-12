package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CompanyStaff;



public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer> {

}
