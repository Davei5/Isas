package io.renren.modules.grades.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.grades.service.UploadScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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
    @RequiresPermissions("generator:grades:list")
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
