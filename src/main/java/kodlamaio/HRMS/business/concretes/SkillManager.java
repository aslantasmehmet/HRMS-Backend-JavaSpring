package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SkillService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SkillDao;
import kodlamaio.HRMS.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		skillDao.save(skill);
		return new SuccessResult("Yeni Yetenek Eklendi.");
	}

	@Override
	public Result update(Skill skill) {
		skillDao.save(skill);
		return new SuccessResult("Yetenek GÜncellendi.");
		
	}

	@Override
	public Result delete(int id) {
		skillDao.deleteById(id);
		return new SuccessResult("Yetenek Silindi.");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<>(this.skillDao.findAll());
	}

	@Override
	public DataResult<Skill> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
