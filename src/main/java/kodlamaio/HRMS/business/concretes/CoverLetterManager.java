package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CoverLetterService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	
	private CoverLetterDao coverLetterDao;

	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön Yazı Eklendi.");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new SuccessResult("Öz Yazı Güncellendi.");
	}

	@Override
	public Result delete(int id) {
		coverLetterDao.deleteById(id);
		return new SuccessResult("Ön Yazı Silindi.");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<>(this.coverLetterDao.findAll());
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getByCandidate_Id(candidateId));
	}
}

