package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	
	Image getByUser_Id(int userId);

}
