package io.renren.modules.studentes.service.impl;

import io.renren.modules.studentes.dao.StudentDao;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.studentes.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

/**
 * Service实现类
 */

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<StudentEntity>()
                .like("stuid",params.get("key"))
        );

        return new PageUtils(page);
    }

}