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

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.User;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getByIdentityNumber")
	public DataResult<Candidate> getByIdentityNumber(String identityNumber){
		return this.candidateService.getByIdentityNumber(identityNumber);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate){
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  Candidate candidate){
		return ResponseEntity.ok(this.candidateService.delete(candidate));
	}
	
	

}
