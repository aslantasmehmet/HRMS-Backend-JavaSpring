package kodlamaio.HRMS.business.concretes;

import java.util.List;



import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.PositionService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.PositionDao;
import kodlamaio.HRMS.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	
	private PositionDao positionDao;

	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Tüm Pozisyonlar Listelendi.");
	}

	@Override
	public Result add(Position position) {
		this.positionDao.save(position);
			return new SuccessResult("Pozisyon eklendi.");
		
	}

}
