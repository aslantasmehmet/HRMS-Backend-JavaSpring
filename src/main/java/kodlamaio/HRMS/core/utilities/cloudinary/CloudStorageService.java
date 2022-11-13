package kodlamaio.HRMS.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.result.DataResult;

public interface CloudStorageService {
	
	DataResult<?> upload(MultipartFile multipartFile);
	
	DataResult<?> delete(String publicIdOfImage);

}
