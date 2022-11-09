package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.core.utilities.result.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.result.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ImageDao;
import kodlamaio.HRMS.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {
	
	
	private ImageDao imageDao;
	private UserService service;


	

	@Override
	public Result add(Image image) {
		imageDao.save(image);
		return new  SuccessResult("Fotograf Eklendi.");
	}

	@Override
	public Result update(Image image) {
		imageDao.save(image);
		return new SuccessResult("Fotoğraf Güncellendi.");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<>(this.imageDao.getById(id));
	}

	@Override
	public Result upload(int userId, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Image> getByUserId(int userId) {
		return new SuccessDataResult<>(this.imageDao.getByUser_Id(userId));
	}

}
