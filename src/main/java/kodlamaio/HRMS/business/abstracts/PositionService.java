package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import javax.swing.text.Position;

import kodlamaio.HRMS.core.utilities.result.DataResult;

public interface PositionService {
	
	DataResult<List<Position>> getAll();

}
