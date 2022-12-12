package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.JobTitle;

public interface JobTitleService extends EntitiyService<JobTitle> {

	DataResult<JobTitle > getByTitle(String title);

}
