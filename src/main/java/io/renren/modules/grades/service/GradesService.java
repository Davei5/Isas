package io.renren.modules.grades.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.grades.entity.GradesEntity;

import java.util.Map;

/**
 * 
 *成绩表 Service层
 * 实现基本增删改查
 */
public interface GradesService extends IService<GradesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

