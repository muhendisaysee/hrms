package kodlamaio.hrms.adapter.cloudinary.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    Map upload(MultipartFile file) throws IOException;
}
