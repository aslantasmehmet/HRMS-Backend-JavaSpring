package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.WorkingTypeService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.HRMS.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService {
	
	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult();
	}

	@Override
	public Result update(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		
		workingTypeDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "type");
		
		return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll(sort));
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		return new SuccessDataResult<WorkingType>(workingTypeDao.getById(id));
	}

}
