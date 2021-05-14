package io.renren.modules.synthesis.controller;

import io.renren.common.utils.R;
import io.renren.modules.synthesis.service.UploadScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实现上传文件，添加智育成绩和体侧成绩
 * @author
 */
@RestController
@RequestMapping("/synthesis/upload")
public class uploadScoreController {

    @Autowired
    private UploadScoreService uploadScoreService;

    /**
     * 上传Excel文件，导入智育成绩和体侧成绩
     * @param file
     * @return
     */
    @RequestMapping("/import")
    public R addGrades(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        try{
            uploadScoreService.batchImport(fileName,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.ok();
    }

}
