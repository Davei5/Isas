package io.renren;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;
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

    @Autowired
    private UploadScoreService uploadScoreService;

    /**
     * 测试按班级查询学生
     */
    @Test
    public void fun1(){
        String username = "2017122245141";
        List<StudentEntity> listStus = synthesisService.selClassNameStu(username);
        for (StudentEntity list:listStus){
            System.out.println(list);
        }
    }

    /**
     * 测试添加日常行为规范分
     */
    @Test
    public void fun2(){
        double dailybehavior = 5.00;
        String stuid = "12";
        GradesEntity gradesEntity = new GradesEntity();
        gradesEntity.setDailybehavior(dailybehavior);
        gradesEntity.setStuid(stuid);
        synthesisService.updateDailybehavior(gradesEntity);
        System.out.println(gradesEntity);
    }

    /**
     * 测试添加小组测评人员
     */
    @Test
    public void fun3(){
        String stuid = "2017122245141";
        synthesisService.addSmallGroup(stuid);
    }

    /**
     * 测试取消小组测评资格
     */
    @Test
    public void fun4(){
        String stuid="2017122245141";
        synthesisService.deleteSmallGroup(stuid);
    }

    /**
     * 测试自评分
     */
    @Test
    public void fun5(){
        String stuid = "2017122245142";
        Double self = 4.00;
        IntellectuallyEntity intellectuallyEntity = new IntellectuallyEntity();
        intellectuallyEntity.setSelf(self);
        intellectuallyEntity.setStuid(stuid);
        int inc = synthesisService.selectStuId(stuid);
        if (inc != 0 ){
            synthesisService.updateSelf(intellectuallyEntity);
            System.out.println("修改"+intellectuallyEntity);
        }else{
            synthesisService.addSelf(intellectuallyEntity);
            System.out.println("添加"+intellectuallyEntity);
        }
    }

    /**
     * 测试小组评分
     * 无数据出错，有数据成功
     */
    @Test
    public void fun6(){
        String stuid = "2017122245141";
        Double smallgroup = 4.00;
        IntellectuallyEntity intellectuallyEntity = new IntellectuallyEntity();
        intellectuallyEntity.setSmallgroup(smallgroup);
        intellectuallyEntity.setStuid(stuid);
        int inc = synthesisService.selectStuId(stuid);
        if (inc != 0 ){
            synthesisService.updateGroupScore(intellectuallyEntity);
            System.out.println("修改"+intellectuallyEntity);
        }else{
            synthesisService.addGroupScore(intellectuallyEntity);
            System.out.println("添加"+intellectuallyEntity);
        }
    }


    /**
     * 测试添加智育和体侧成绩
     * @throws Exception
     */
    @Test
    public void fun() throws Exception{
        String fileNa = "Test.xlsx";
        File file = new File("D:\\Test.xlsx");

        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);

        uploadScoreService.batchImport(fileNa,multipartFile);

    }

}
