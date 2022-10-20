package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EducationService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EducationDao;
import kodlamaio.HRMS.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	
	private EducationDao educationDao;

	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		educationDao.save(education);
		return new SuccessResult("Eğitim Bilgileri Eklendi.");
	}

	@Override
	public Result update(Education education) {
		educationDao.save(education);
		return new SuccessResult("Eğitim Bilgileri Güncellendi.");
	}

	@Override
	public Result delete(int id) {
		educationDao.deleteById(id);
		return new SuccessResult("Eğitim Bilgileri Silindi.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<>(this.educationDao.findAll());
	}

	@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<>(this.educationDao.getById(id));
	}

	@Override
	public DataResult<List<Education>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<>(this.educationDao.getByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");
		
		return new SuccessDataResult<>(this.educationDao.getByResume_Id(resumeId, sort)); 
	}
}
