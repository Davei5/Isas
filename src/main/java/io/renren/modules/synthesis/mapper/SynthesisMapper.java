package io.renren.modules.synthesis.mapper;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper
 */
@Mapper
public interface SynthesisMapper {

    /**
     * 添加智育、体侧成绩
     */
    void addIntellectually(GradesEntity gradesEntity);

    /**
     * 如果学号存在，则为修改成绩
     * @param gradesEntity
     * @return
     */
    int updateByStuid(GradesEntity gradesEntity);

    /**
     * 按学号查询，改成绩是否存在
     * @param stuid
     * @return
     */
    int findByStuid(String stuid);



    /**
     * 查询班级学生
     * @param username 登录用户名
     */
    List<StudentEntity> selClassNameStu(String username);


    /**
     *  输出本班级的学生成绩
     */

}
