package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.EducationService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	
	
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return educationService.add(education);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Education education) {
		return educationService.update(education);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestParam  int id){
		return ResponseEntity.ok(educationService.delete(id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll(){
		return educationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Education> getById(@RequestParam int id ){
		return  educationService.getById(id);
	}
	
	@GetMapping("/getAllByResumeIdSortedByGraduationDate")
	public DataResult<List<Education>>getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId ){
		return educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
	}
	


}
