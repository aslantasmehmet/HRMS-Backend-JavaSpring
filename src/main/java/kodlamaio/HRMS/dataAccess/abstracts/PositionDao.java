package kodlamaio.HRMS.dataAccess.abstracts;



import java.util.List;
import kodlamaio.HRMS.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PositionDao extends JpaRepository<Position, Integer> {
	
	List<Position> findAllByPositionName (String positionName);
	
	
	
	
	


}
