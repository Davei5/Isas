package io.renren.modules.grades.mapper;

import io.renren.modules.grades.entity.GradesEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradesMapper {

    /**
     * 添加智育、体侧成绩
     */
    void addIntellectually(GradesEntity gradesEntity);

    int updateByName(GradesEntity gradesEntity);

    int findByStuid(String stuid);
}
