package io.renren.modules.synthesis.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 实现 上传文件添加智育和体侧成绩
 */
public interface UploadScoreService {

    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
