package kodlamaio.HRMS.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CompanyStaff;

public interface CompanyStaffService extends JpaRepository<CompanyStaff, Integer>{

}
