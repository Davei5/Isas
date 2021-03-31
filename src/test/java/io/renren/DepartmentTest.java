package io.renren;

import io.renren.modules.department.entity.DepartmentEntity;
import io.renren.modules.department.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 系部表的测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {

        @Autowired
        private DepartmentService departmentService;

        @Test
        public void test(){
            List<DepartmentEntity> departmentList =  departmentService.findByName("信管系");
            System.out.println(departmentList);
        }

    }

