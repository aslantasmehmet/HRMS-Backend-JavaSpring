package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.WorkExperienceService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.HRMS.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService {
	
	private WorkExperienceDao workExperienceDao;
	
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	

	@Override
	public Result add(WorkExperience entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(WorkExperience entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<WorkExperience> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<WorkExperience> getAllResumeId(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<WorkExperience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"terminationDate");
		
		return new SuccessDataResult<List<WorkExperience>>(workExperienceDao.getByResume_Id(resumeId, sort));
	}
	
	

}
