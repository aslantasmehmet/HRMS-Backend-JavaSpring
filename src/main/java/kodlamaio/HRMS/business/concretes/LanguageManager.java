package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.LanguageDao;
import kodlamaio.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult("Dil Bilgii Eklendi.");
	}

	@Override
	public Result update(Language language) {
		languageDao.save(language);
		return new SuccessResult("Dil Bilgii Güncellendi");
	}

	@Override
	public Result delete(int id) {
		languageDao.deleteById(id);
		return new SuccessResult("Dil Bilgisi Silindi.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<>(this.languageDao.getById(id));
	}
}
