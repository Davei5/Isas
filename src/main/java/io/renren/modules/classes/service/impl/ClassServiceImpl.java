package io.renren.modules.classes.service.impl;

import io.renren.modules.classes.dao.ClassDao;
import io.renren.modules.classes.entity.ClassEntity;
import io.renren.modules.classes.service.ClassService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

/**
 * service实现类
 */

@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ClassEntity> page = this.page(
                new Query<ClassEntity>().getPage(params),
                new QueryWrapper<ClassEntity>()
                .like("classname",params.get("key"))
        );

        return new PageUtils(page);
    }

}