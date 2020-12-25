package io.renren.modules.synthesis.controller;

import io.renren.modules.synthesis.service.UploadScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实现上传文件，添加智育成绩和体侧成绩
 */
@RestController
@RequestMapping("/test")
public class uploadScoreController {

    @Autowired
    private UploadScoreService uploadScoreService;

    /**
     * 上传Excel文件，导入智育成绩和体侧成绩
     * @param file
     * @return
     */
    @RequestMapping("/import")
    @RequiresPermissions("generator:synthesis:upload")
    public boolean addGrades(@RequestParam("file") MultipartFile file){
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try{
            a = uploadScoreService.batchImport(fileName,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

}
