package io.renren.modules.department.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.department.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-07 20:06:01
 */
public interface DepartmentService extends IService<DepartmentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 按name查询
     * @param name
     * @return
     */
    List<DepartmentEntity> findByName(String name);
}

