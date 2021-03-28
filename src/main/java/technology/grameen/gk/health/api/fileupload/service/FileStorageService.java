package technology.grameen.gk.health.api.fileupload.service;

import org.springframework.web.multipart.MultipartFile;
import technology.grameen.gk.health.api.fileupload.response.UploadResponse;

public interface FileStorageService {

    UploadResponse storeFile(MultipartFile file);

}
