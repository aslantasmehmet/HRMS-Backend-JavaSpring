package kodlamaio.HRMS.core.utilities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HRMS.core.utilities.cloudinary.CloudStorageService;
import kodlamaio.HRMS.core.utilities.cloudinary.CloudinaryServiceAdapter;

@Configuration
public class CloudinaryConfig {
	
	@Bean 
	public Cloudinary cloudinaryAccount() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "",
				"api_key", "",
				"api_secret", ""
				));
	}

	@Bean
	public CloudStorageService cloudStorageService() {
		return new CloudinaryServiceAdapter(cloudinaryAccount());
	}

}
