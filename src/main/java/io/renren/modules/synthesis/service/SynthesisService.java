package io.renren.modules.synthesis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;


import java.util.List;

/**
 * 实现一些增删改查的基本功能
 */
public interface SynthesisService extends IService<StudentEntity> {

    /**
     * 通过当前登录用户，查询其本班所有学生
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
    int selectStuId(String stuid);















}
