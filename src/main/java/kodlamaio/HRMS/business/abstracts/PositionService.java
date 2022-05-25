package kodlamaio.HRMS.business.abstracts;

import java.util.List;


import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Position;

public interface PositionService {
	
	DataResult<List<Position>> getAll();
	
	Result add (Position position);
	Result delete (Position posiiton);
	Result update (Position position);

}
