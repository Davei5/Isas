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

/**
 * Service实现类
 *  基本增删改查
 */
@Service("gradesService")
public class GradesServiceImpl extends ServiceImpl<GradesDao, GradesEntity> implements GradesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GradesEntity> page = this.page(
                new Query<GradesEntity>().getPage(params),
                new QueryWrapper<GradesEntity>()
                .like("stuid",params.get("key"))
        );

        return new PageUtils(page);
    }

}