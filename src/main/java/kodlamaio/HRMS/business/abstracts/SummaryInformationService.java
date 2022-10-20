package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.SummaryInformation;

public interface SummaryInformationService extends EntitiyService<SummaryInformation>{

	DataResult<List<SummaryInformation>> getAllByCandidateId (int candidateId);
}
