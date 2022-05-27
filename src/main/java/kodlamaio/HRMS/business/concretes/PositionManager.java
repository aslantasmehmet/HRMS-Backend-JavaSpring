package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import kodlamaio.HRMS.business.abstracts.PositionService;
import kodlamaio.HRMS.core.utilities.business.BusinessRules;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.ErrorResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.PositionDao;
import kodlamaio.HRMS.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	
	private PositionDao positionDao;

	@Autowired
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
		var result = BusinessRules.run(
					CheckIfThePositionName(position)
					);
		if(result != null) {
			return result;
		}
		this.positionDao.save(position);
		return new SuccessResult("Pozisyon Ekleme İşlemi Başarılı.");
		
	}

	@Override
	public Result delete(Position posiiton) {
		this.positionDao.delete(posiiton);
		return new SuccessResult("Pozisyon Silme İşlemi Başarılı.");
	}

	@Override
	public Result update(Position position) {
		this.positionDao.save(position);
		return new SuccessResult("Pozisyon Güncelleme İşlemi Başarılı.");
	}
	
	private Result CheckIfThePositionName(Position position) {
		if(positionDao.findAllByPositionName(position.getPositionName()).stream().count() !=0) {
			return new ErrorResult("'" + position.getPositionName() + "'" + "Bu Pozisyon daha önce eklenmiştir." );
		}
		return new SuccessResult();
	}

}
