package io.renren.modules.studentes.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.studentes.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-09 09:18:26
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
