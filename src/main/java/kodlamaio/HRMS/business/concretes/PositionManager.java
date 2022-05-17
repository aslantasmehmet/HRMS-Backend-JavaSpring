package kodlamaio.HRMS.business.concretes;

import java.util.List;

import javax.swing.text.Position;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.PositionService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.PositionDao;

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

}
