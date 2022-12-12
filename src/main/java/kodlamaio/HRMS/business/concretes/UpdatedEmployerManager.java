package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UpdatedEmployerService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UpdatedEmployerDao;
import kodlamaio.HRMS.entities.concretes.UpdatedEmployer;



@Service
public class UpdatedEmployerManager implements UpdatedEmployerService  {

	private UpdatedEmployerDao updatedEmployerDao;

	@Autowired
	public UpdatedEmployerManager(UpdatedEmployerDao updatedEmployerDao) {
		this.updatedEmployerDao = updatedEmployerDao;
	}

	@Override
	public Result add(UpdatedEmployer updatedEmployer) {

		updatedEmployerDao.save(updatedEmployer);
		return new SuccessResult("Güncellenmiş işveren eklendi.");
	}

	@Override
	public Result update(UpdatedEmployer updatedEmployer) {

		updatedEmployerDao.save(updatedEmployer);
		return new SuccessResult("Güncellenmiş işveren güncellendi.");
	}

	@Override
	public Result delete(int id) {

		updatedEmployerDao.deleteById(id);
		return new SuccessResult("Güncellenmiş işveren silindi.");
	}

	@Override
	public DataResult<List<UpdatedEmployer>> getAll() {
		return new SuccessDataResult<List<UpdatedEmployer>>(updatedEmployerDao.findAll());
	}

	@Override
	public DataResult<UpdatedEmployer> getById(int id) {
		return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getById(id));
	}

	@Override
	public DataResult<UpdatedEmployer> getByEmployerId(int employerId) {
		return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getByEmployer_Id(employerId));
	}

}