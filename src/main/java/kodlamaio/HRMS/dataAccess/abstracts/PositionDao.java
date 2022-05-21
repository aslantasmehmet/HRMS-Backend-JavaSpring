package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
	
	
	
	List<Position> getByPositionName (String positionName);
	


}
