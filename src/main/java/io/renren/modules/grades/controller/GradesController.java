package io.renren.modules.grades.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.grades.service.GradesService;
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
 * @date 2020-12-09 09:45:17
 */
@RestController
@RequestMapping("generator/grades")
public class GradesController {
    @Autowired
    private GradesService gradesService;


    /**
     *
     *Dave
     */

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:grades:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gradesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{graid}")
    @RequiresPermissions("generator:grades:info")
    public R info(@PathVariable("graid") Integer graid){
        GradesEntity grades = gradesService.getById(graid);

        return R.ok().put("grades", grades);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:grades:save")
    public R save(@RequestBody GradesEntity grades){
        gradesService.save(grades);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:grades:update")
    public R update(@RequestBody GradesEntity grades){
        gradesService.updateById(grades);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:grades:delete")
    public R delete(@RequestBody Integer[] graids){
        gradesService.removeByIds(Arrays.asList(graids));

        return R.ok();
    }

}
