package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{
	
	List<Skill>  getByResume_Id (int resume_Id);
	
	
	List<Skill> getByResume_Id (int resume_Id, Sort sort);

}
