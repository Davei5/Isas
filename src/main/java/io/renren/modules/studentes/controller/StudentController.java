package io.renren.modules.studentes.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.studentes.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-09 09:18:26
 */
@RestController
@RequestMapping("generator/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:student:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stuid}")
    @RequiresPermissions("generator:student:info")
    public R info(@PathVariable("stuid") String stuid){
        StudentEntity student = studentService.getById(stuid);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:student:save")
    public R save(@RequestBody StudentEntity student){
        studentService.save(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:student:update")
    public R update(@RequestBody StudentEntity student){
        studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:student:delete")
    public R delete(@RequestBody String[] stuids){
        studentService.removeByIds(Arrays.asList(stuids));

        return R.ok();
    }

}
