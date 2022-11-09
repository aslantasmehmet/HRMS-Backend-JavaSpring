package kodlamaio.HRMS.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Image;

public interface ImageService extends EntitiyService<Image> {
	
	
	Result upload (int userId, MultipartFile  file);
	
	DataResult<Image> getByUserId (int userId);
}
