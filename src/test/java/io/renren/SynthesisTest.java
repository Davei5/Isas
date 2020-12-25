package io.renren;

import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.mapper.SynthesisMapper;
import io.renren.modules.synthesis.service.SynthesisService;
import io.renren.modules.synthesis.service.UploadScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * 成绩相关操作的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SynthesisTest {

    @Autowired
    private SynthesisService synthesisService;

    @Test
    public void fun1(){
        String username = "2017122245141";
        List<StudentEntity> listStus = synthesisService.selClassNameStu(username);
        for (StudentEntity list:listStus){
            System.out.println(list);
        }
    }


    /*@Autowired
    private UploadScoreService uploadScoreService;


    @Test
    public void fun() throws Exception{
        String fileNa = "Test.xlsx";
        File file = new File("D:\\Test.xlsx");

        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);

        uploadScoreService.batchImport(fileNa,multipartFile);

    }*/
}
