package kodlamaio.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
	
	@Query("From Position Where id = :id")
	List<Position> getById (int id);
	


}
