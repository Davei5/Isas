package io.renren.modules.department.dao;

import io.renren.modules.department.entity.DepartmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 系部表 Dao层
 */
@Mapper
public interface DepartmentDao extends BaseMapper<DepartmentEntity> {
	
}
