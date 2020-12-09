package io.renren.modules.grades.service.impl;

import io.renren.modules.grades.dao.GradesDao;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.grades.service.GradesService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;


@Service("gradesService")
public class GradesServiceImpl extends ServiceImpl<GradesDao, GradesEntity> implements GradesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GradesEntity> page = this.page(
                new Query<GradesEntity>().getPage(params),
                new QueryWrapper<GradesEntity>()
        );

        return new PageUtils(page);
    }

}