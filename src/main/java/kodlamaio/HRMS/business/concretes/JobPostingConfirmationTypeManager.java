package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPostingConfirmationTypeService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPostingConfirmationTypeDao;
import kodlamaio.HRMS.entities.concretes.JobPostingConfirmationType;

@Service
public class JobPostingConfirmationTypeManager implements JobPostingConfirmationTypeService {

	private JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao;

	@Autowired
	public JobPostingConfirmationTypeManager(JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao) {
		this.jobPostingConfirmationTypeDao = jobPostingConfirmationTypeDao;
	}

	@Override
	public Result add(JobPostingConfirmationType entity) {
		return new SuccessResult("İş ilanı onay tipi eklendi.");
	}

	@Override
	public Result update(JobPostingConfirmationType entity) {
		return new SuccessResult("İş ilanı onay tipi güncellendi.");
	}

	@Override
	public Result delete(int id) {
		return new SuccessResult("İş ilanı onay tipi silindi.");
	}

	@Override
	public DataResult<List<JobPostingConfirmationType>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirmationType>>(jobPostingConfirmationTypeDao.findAll());
	}

	@Override
	public DataResult<JobPostingConfirmationType> getById(int id) {
		return new SuccessDataResult<JobPostingConfirmationType>(jobPostingConfirmationTypeDao.getById(id));
	}

}