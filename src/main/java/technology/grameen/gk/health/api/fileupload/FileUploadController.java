package technology.grameen.gk.health.api.fileupload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import technology.grameen.gk.health.api.fileupload.response.UploadResponse;
import technology.grameen.gk.health.api.fileupload.service.FileStorageService;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;


@RestController
@RequestMapping("/api/v1/file-upload")
public class FileUploadController {

    FileStorageService fileStorageService;

    FileUploadController(FileStorageService fileStorageService){
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<IResponse> uploadFile(@RequestParam("file") MultipartFile file){
        UploadResponse fileUploaded = fileStorageService.storeFile(file);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),fileUploaded), HttpStatus.OK);
    }
}
