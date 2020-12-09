package io.renren.modules.grades.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.grades.entity.GradesEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-07 19:48:44
 */
public interface GradesService extends IService<GradesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

