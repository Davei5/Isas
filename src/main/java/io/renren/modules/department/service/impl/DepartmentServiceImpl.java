package io.renren.modules.department.service.impl;

import io.renren.modules.department.dao.DepartmentDao;
import io.renren.modules.department.entity.DepartmentEntity;
import io.renren.modules.department.mapper.DepartmentMapper;
import io.renren.modules.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {


    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DepartmentEntity> page = this.page(
                new Query<DepartmentEntity>().getPage(params),
                new QueryWrapper<DepartmentEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 按name查询
     * @param name
     * @return
     */
    @Override
    public List<DepartmentEntity> findByName(String name) {
        return departmentMapper.list(name);
    }

}