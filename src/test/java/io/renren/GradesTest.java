package io.renren;

import io.renren.modules.grades.service.UploadScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.InputStream;

/**
 * 成绩相关操作的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradesTest {

    @Autowired
    private UploadScoreService uploadScoreService;

    @Test
    public void fun(){
    }
}
