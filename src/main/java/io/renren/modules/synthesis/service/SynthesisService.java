package io.renren.modules.synthesis.service;

import io.renren.modules.studentes.entity.StudentEntity;

import java.util.List;

/**
 * 实现一些增删改查的基本功能
 */
public interface SynthesisService {

    /**
     * 通过当前登录用户，查询其本班所有学生
     * @param username 登录用户名
     */
    List<StudentEntity> selClassNameStu(String username);

}
