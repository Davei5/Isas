package io.renren.modules.grades.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadScoreService {

    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
