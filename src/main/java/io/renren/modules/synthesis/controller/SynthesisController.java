package io.renren.modules.synthesis.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.R;
import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.entity.IntellectuallyEntity;
import io.renren.modules.synthesis.service.SynthesisService;
import io.renren.modules.synthesis.service.UploadScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/synthesis")
public class SynthesisController {

    @Autowired
    private SynthesisService synthesisService;

    @Autowired
    private UploadScoreService uploadScoreService;

    /**
     *      当前测试，最后需修改为String类型，返回 "list"
     * 按当前学号查询出班级后，显示相同班级的成绩
     * @param stuId  学号
     * @param model
     * @param start
     * @param size
     * @return dd
     */
    @GetMapping("/list")
    public List<StudentEntity> listSelClassStu(String stuId, Model model, @RequestParam(value = "start",defaultValue = "0")
            int start, @RequestParam(value = "size",defaultValue = "10") int size){
        PageHelper.startPage(start,size,"id desc");
        List<StudentEntity> stus = synthesisService.selClassNameStu(stuId);
        PageInfo<StudentEntity> page = new PageInfo<>(stus);
        model.addAttribute("page",page);

        return page.getList();
    }

    /**
     * 添加日常行为规范分，默认值为0，所以实际操作为修改
     * @param gradesEntity
     * @return
     */
    @PostMapping("/updateDailybehavior")
    public R updateDailybehavior(@RequestBody GradesEntity gradesEntity){
        System.out.println(gradesEntity);
        synthesisService.updateDailybehavior(gradesEntity);
        return R.ok();
    }

    /**
     *  插入数据之后，数据库中值为null
     * 添加小组测评人员
     * @param stuid 学号
     * @return
     */
    @PostMapping("/addSmallGroup")
    public R addSmallGroup(String stuid){
        synthesisService.addSmallGroup(stuid);
        return  R.ok();
    }

    /**
     * 测试取消小组测评资格
     * @param stuid 学号
     */
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
