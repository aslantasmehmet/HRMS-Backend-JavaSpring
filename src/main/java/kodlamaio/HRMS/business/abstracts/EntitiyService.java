package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;

public interface EntitiyService<T> {
	
	Result add(T entity);

	Result update(T entity);

	Result delete(int id);

	DataResult<List<T>> getAll();

	DataResult<T> getById(int id);

}
