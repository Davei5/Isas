package io.renren.modules.classes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.classes.entity.ClassEntity;

import java.util.Map;

/**
 * 
 *班级表Service层
 */
public interface ClassService extends IService<ClassEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

