package io.renren.modules.studentes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.studentes.entity.StudentEntity;

import java.util.Map;

/**
 *
 *Service层
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

