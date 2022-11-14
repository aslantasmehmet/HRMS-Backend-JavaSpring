package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.core.utilities.result.DataResult;
import kodlamaio.HRMS.core.utilities.result.Result;
import kodlamaio.HRMS.entities.concretes.Image;

@RestController
@RequestMapping("api/images")
@CrossOrigin
public class ImagesController {
	
	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return imageService.delete(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Image>> getAll() {
		return imageService.getAll();
	}
	
	@GetMapping("/getByUserId")
	public DataResult<Image> getByUserId(@RequestParam int userId) {
		return imageService.getById(userId);
	}
	
	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam int id) {
		return imageService.getById(id);
	}
	
	@PostMapping("/upload")
	public Result upload(@RequestParam int userId,@RequestParam MultipartFile file) {
		return imageService.upload(userId, file);
	}
	
	

}
