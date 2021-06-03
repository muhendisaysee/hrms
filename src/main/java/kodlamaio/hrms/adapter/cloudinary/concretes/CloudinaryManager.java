package kodlamaio.hrms.adapter.cloudinary.concretes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.adapter.cloudinary.abstracts.CloudinaryService;

@Service
public class CloudinaryManager implements CloudinaryService{
	
	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap();
	
	@Autowired
	public CloudinaryManager() {
		//valuesMap.put("cloud_name", "dwy15gvod");
		//valuesMap.put("api_key", "415338817677416");
		//valuesMap.put("api_secret", "Yifa5FsD_FvTPwtvoSTrQCwmbDQ");
		this.cloudinary = new Cloudinary("cloudinary://415338817677416:Yifa5FsD_FvTPwtvoSTrQCwmbDQ@dwy15gvod");
	}
	public Map upload(MultipartFile multipartFile) throws IOException{
		//File file = convert(multipartFile);
		//Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		//file.delete();
		//return result;
		Map upload = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		return upload;
	}
	
	/*public Map delete(String id) throws IOException{
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}
	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.close();
		return file;
	}*/

	
}
