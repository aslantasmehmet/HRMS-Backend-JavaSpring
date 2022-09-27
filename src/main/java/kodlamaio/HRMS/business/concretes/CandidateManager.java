package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private  CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}



	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<>(this.candidateDao.findAll(),
				"Tüm Adaylar Listelendi.");
	}



	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<>(this.candidateDao.getByIdentityNumber(identityNumber)
				,"Kimlik Numarasına Göre  Adaylar Listelendi.");
	}



	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);		
		return new SuccessResult("Kayıt Olma İşlemi Başarılı");
	}
	
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Silme İşlemi Başarılı");
	}

}
