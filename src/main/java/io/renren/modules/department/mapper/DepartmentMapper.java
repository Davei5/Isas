package io.renren.modules.department.mapper;

import io.renren.modules.department.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    public List<DepartmentEntity> list(String name);
}
