package technology.grameen.gk.health.api.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String storeFile(MultipartFile file);

}
