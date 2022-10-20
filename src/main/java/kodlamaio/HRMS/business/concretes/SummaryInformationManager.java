package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SummaryInformationService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SummaryInformationDao;
import kodlamaio.HRMS.entities.concretes.SummaryInformation;

@Service
public class SummaryInformationManager implements SummaryInformationService {

	
	private SummaryInformationDao summaryInformationDao;

	public SummaryInformationManager(SummaryInformationDao summaryInformationDao) {
		super();
		this.summaryInformationDao = summaryInformationDao;
	}

	@Override
	public Result add(SummaryInformation summaryInformation) {
		summaryInformationDao.save(summaryInformation);
		return new SuccessResult("Kişi Bilgileri Eklendi.");
	}

	@Override
	public Result update(SummaryInformation summaryInformation) {
		summaryInformationDao.save(summaryInformation);
		return new SuccessResult("Kişi Bilgileri Güncellendi.");
	}

	@Override
	public Result delete(int id) {
		summaryInformationDao.deleteById(id);
		return new SuccessResult("Kişi Bilgileri Silindi.");
	}

	@Override
	public DataResult<List<SummaryInformation>> getAll() {
		return new SuccessDataResult<>(this.summaryInformationDao.findAll());
	}

	@Override
	public DataResult<SummaryInformation> getById(int id) {
		return new SuccessDataResult<>(this.summaryInformationDao.getById(id));
	}

	@Override
	public DataResult<List<SummaryInformation>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SummaryInformation>>(this.summaryInformationDao.getByCandidate_Id(candidateId));
	} 
}
