package io.renren.modules.classes.dao;

import io.renren.modules.classes.entity.ClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *班级表Dao层
 */
@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {
	
}
