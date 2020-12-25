package io.renren.modules.synthesis.service.impl;

import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.mapper.SynthesisMapper;
import io.renren.modules.synthesis.service.SynthesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SynthesService的实现类
 */

@Service("synthesisService")
public class SynthesisServiceImpl implements SynthesisService {

    @Autowired
    private SynthesisMapper synthesisMapper;

    /**
     * 查询班级学生
     * @param username 登录用户名
     */
    @Override
    public List<StudentEntity> selClassNameStu(String username) {

        List<StudentEntity> lists = synthesisMapper.selClassNameStu(username);
        return lists;
    }





}
