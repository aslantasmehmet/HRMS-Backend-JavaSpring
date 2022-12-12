package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.entities.concretes.UpdatedEmployer;

public interface UpdatedEmployerService extends EntitiyService<UpdatedEmployer> {

	DataResult<UpdatedEmployer> getByEmployerId(int employerId);

}
