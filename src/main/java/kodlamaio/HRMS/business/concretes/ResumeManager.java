package kodlamaio.HRMS.business.concretes;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeDao;
import kodlamaio.HRMS.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {
	
	
	private ResumeDao resumeDao;

	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(Resume resume) {
		resume.setCreationDate(LocalDateTime.now());
		
		resumeDao.save(resume);
		return new SuccessResult(
				"Özgeçmiş Başarılı İle Oluşturuldu.");
	}

	@Override
	public Result update(Resume resume) {
		resume = getById(resume.getId()).getData();
		resume.setCreationDate(LocalDateTime.now());
		
		resumeDao.save(resume);
		return new SuccessResult(
				"Özgeçmiş Başarılı Bir Şekilde Güncellendi");
	}

	@Override
	public Result delete(int id) {
		resumeDao.deleteById(id);
		return new SuccessResult("Silme İşlemi Başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<>(this.resumeDao.getById(id));
	}

	@Override
	public DataResult<Resume> getByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.resumeDao.getByCandidate_Id(candidateId));
	}

}
