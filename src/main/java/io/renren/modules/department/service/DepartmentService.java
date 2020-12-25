package io.renren.modules.department.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.department.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 *系部表 Service层
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

