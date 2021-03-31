package io.renren.modules.synthesis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 */
@Mapper
public interface SynthesisMapper extends BaseMapper<StudentEntity> {

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
     * 添加日常行为规范分
     * @param gradesEntity
     */
    void updateDailybehavior(GradesEntity gradesEntity);

    /**
     * 设置小组测评人员
     * @param stuid
     */
    void addSmallGroup(String stuid);

    /**
     * 取消小组测评人员资格
     * @param stuid
     */
    void deleteSmallGroup(String stuid);

    /**
     * 小组人员评分:添加
     * @param intellectuallyEntity
     */
    void addGroupScore(IntellectuallyEntity intellectuallyEntity);

    /**
     * 小组人员评分:修改
     * @param intellectuallyEntity
     */
    void updateGroupScore(IntellectuallyEntity intellectuallyEntity);

    /**
     * 自评分：添加
     * @param intellectuallyEntity
     */
    void addSelf(IntellectuallyEntity intellectuallyEntity);

    /**
     * 自评分：修改
     * @param intellectuallyEntity
     */
    void updateSelf(IntellectuallyEntity intellectuallyEntity);

    /**
     * 按学号查询，自评分或小组评分是否存在
     */
    int selectStuid(String stuid);

    /**
     *  输出本班级的学生成绩
     */

}
