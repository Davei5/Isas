package io.renren.modules.synthesis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.R;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.grades.service.GradesService;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.studentes.service.StudentService;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;
import io.renren.modules.synthesis.service.SynthesisService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/synthesis")
public class SynthesisController {

    @Autowired
    private SynthesisService synthesisService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradesService gradesService;

    /**
     *学习成绩权重
     */
    @Value(value = "alltest.weight.study")
    private String study;

    /**
     *自评权重
     */
    @Value(value = "alltest.weight.self")
    private String self;

    /**
     *小组评分权重
     */
    @Value(value = "alltest.weight.group")
    private String group;

    /**
     *身体素质
     */
    @Value(value = "alltest.weight.physical")
    private String physical;

    /**
     *参与时长
     */
    @Value(value = "alltest.weight.hour")
    private String hour;


    /**
     * 按当前学号查询出班级后，显示相同班级的成绩
     * @param semesters 成绩所属学期
     * @param model
     * @param start
     * @param size
     * @return dd
     */
    @GetMapping("/list")
    @ApiOperation(value = "返回本班级成绩",notes = "分页显示，本班级成绩列表")
    public R listSelClassStu(String semesters , Model model, @RequestParam(value = "start",defaultValue = "0")
            int start, @RequestParam(value = "size",defaultValue = "10") int size){
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        //当前登录的用户名
        String username = user.getUsername();
        //查找当前用户的班级
        QueryWrapper<StudentEntity> studentWrapper = new QueryWrapper<>();
        studentWrapper.select("classname").eq("stuid",username);
        StudentEntity student = studentService.getOne(studentWrapper);
        String className = student.getClassname();
        List<StudentEntity> list = studentService.list(new QueryWrapper<StudentEntity>().select("stuid").eq("classname", className));
        List<GradesEntity> studentGrade = new ArrayList<>();
        for(StudentEntity s:list){

            studentGrade.add(gradesService.getOne(new QueryWrapper<GradesEntity>().eq("stuid", s.getStuid()).eq("semesters", semesters)));
        }


        PageHelper.startPage(start,size,"id desc");
        PageInfo<GradesEntity> page = new PageInfo<>(studentGrade);

        return R.ok().put("page",page);
    }

    /**
     * 添加日常行为规范分，默认值为3，所以实际操作为修改
     * @param gradesEntity
     * @return
     */
    /*@PostMapping("/updateDailybehavior")
    public R updateDailybehavior(@RequestBody GradesEntity gradesEntity){
        System.out.println(gradesEntity);
        synthesisService.updateDailybehavior(gradesEntity);
        return R.ok();
    }*/

    /**
     *  插入数据之后，数据库中值为null
     * 添加小组测评人员
     * @param stuid 学号
     * @return
     */
    @ApiOperation(value = "添加小组测评人员",notes = "添加小组测评人员")
    @PostMapping("/addSmallGroup")
    public R addSmallGroup(String stuid){
        synthesisService.addSmallGroup(stuid);
        return  R.ok();
    }

    /**
     * 测试取消小组测评资格
     * @param stuid 学号
     */
    @ApiOperation(value = "取消小组测评人员",notes = "取消小组测评人员")
    @PostMapping("/deleteSmallGroup")
    public R deleteSmallGroup(String stuid){
        synthesisService.deleteSmallGroup(stuid);
        return R.ok();
    }

    /**
     * 添加自评分
     * 不存在就添加，存在则修改
     * @param intellectuallyEntity
     * @return
     */
    @ApiOperation(value = "添加自评分",notes = "添加自评分，不存在添加，存在修改")
    @PostMapping("/addOrUpdateSelf")
    public R addOrUpdateSelf(@RequestBody IntellectuallyEntity intellectuallyEntity) {
        int inc = synthesisService.selectStuId(intellectuallyEntity.getStuid());
        if (inc != 0) {
            synthesisService.updateSelf(intellectuallyEntity);
            System.out.println("修改" + intellectuallyEntity);
        } else {
            synthesisService.addSelf(intellectuallyEntity);
            System.out.println("添加" + intellectuallyEntity);
        }

        return R.ok();
    }

    /**
     * 小组评分
     * 不存在就添加，存在则修改
     * @param intellectuallyEntity
     * @return
     */
    @ApiOperation(value = "小组评分",notes = "小组评分，不存在就添加，存在则修改")
    @PostMapping("/addOrUpdateGroupScore")
    public R addOrUpdateGroupScore(@RequestBody IntellectuallyEntity intellectuallyEntity) {
        int inc = synthesisService.selectStuId(intellectuallyEntity.getStuid());
        if (inc != 0 ){
            synthesisService.updateGroupScore(intellectuallyEntity);
            System.out.println("修改"+intellectuallyEntity);
        }else{
            synthesisService.addGroupScore(intellectuallyEntity);
            System.out.println("添加"+intellectuallyEntity);
        }

        return R.ok();
    }

}
