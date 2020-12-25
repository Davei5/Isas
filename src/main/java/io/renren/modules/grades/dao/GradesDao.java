package io.renren.modules.grades.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.grades.entity.GradesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成绩表 Dao层
 */
@Mapper
public interface GradesDao extends BaseMapper<GradesEntity> {
	
}
