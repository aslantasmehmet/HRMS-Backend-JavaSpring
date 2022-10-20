package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.SkillService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {
	
	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	} 
	
	@PostMapping("/add")
	public Result  add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteById(int id){
		return ResponseEntity.ok(this.skillService.delete(id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	

}
