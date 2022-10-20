package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

public interface CoverLetterService extends EntitiyService<CoverLetter> {
	
	DataResult<List<CoverLetter>> getAllByCandidateId (int candidateId);

}
