package io.renren.modules.synthesis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;
import io.renren.modules.synthesis.mapper.SynthesisMapper;
import io.renren.modules.synthesis.service.SynthesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.repository.query.ExampleQueryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SynthesisService的实现类
 */

@Service("synthesisService")
public class SynthesisServiceImpl extends ServiceImpl<SynthesisMapper,StudentEntity> implements SynthesisService{

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

    /**
     * 添加日常行为规范
     * @param gradesEntity
     */
    @Override
    public void updateDailybehavior(GradesEntity gradesEntity) {
        synthesisMapper.updateDailybehavior(gradesEntity);

    }

    /**
     * 设置小组测评人员
     * @param stuid
     */
    @Override
    public void addSmallGroup(String stuid) {
        synthesisMapper.addSmallGroup(stuid);
    }

    /**
     * 取消小组测评人员资格
     * @param stuid
     */
    @Override
    public void deleteSmallGroup(String stuid) {
        synthesisMapper.deleteSmallGroup(stuid);
    }

    /**
     * 小组人员评分：添加
     * @param intellectuallyEntity
     */
    @Override
    public void addGroupScore(IntellectuallyEntity intellectuallyEntity) {
        synthesisMapper.addGroupScore(intellectuallyEntity);
    }

    /**
     * 小组人员评分：修改
     * @param intellectuallyEntity
     */
    @Override
    public void updateGroupScore(IntellectuallyEntity intellectuallyEntity) {
        synthesisMapper.updateGroupScore(intellectuallyEntity);
    }

    /**
     * 自评分:添加
     * @param intellectuallyEntity
     */
    @Override
    public void addSelf(IntellectuallyEntity intellectuallyEntity) {
        synthesisMapper.addSelf(intellectuallyEntity);
    }

    /**
     * 自评分：修改
     * @param intellectuallyEntity
     */
    @Override
    public void updateSelf(IntellectuallyEntity intellectuallyEntity) {
        synthesisMapper.updateSelf(intellectuallyEntity);
    }

    /**
     * 按学号查询，自评分或小组评分是否存在
     */
    @Override
    public int selectStuId(String stuid) {
        return synthesisMapper.selectStuid(stuid);
    }

}
