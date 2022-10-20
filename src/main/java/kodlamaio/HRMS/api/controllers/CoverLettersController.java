package kodlamaio.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CoverLetterService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
@CrossOrigin
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CoverLetter coverLetter){
		return ResponseEntity.ok(this.coverLetterService.add(coverLetter));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteById(int id){
		return ResponseEntity.ok(this.coverLetterService.delete(id));
	}

	
	@GetMapping("/getAll")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	
}
