package io.renren.modules.studentes.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.studentes.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *Dao层
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
