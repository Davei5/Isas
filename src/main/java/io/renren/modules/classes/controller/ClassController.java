package io.renren.modules.classes.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.classes.entity.ClassEntity;
import io.renren.modules.classes.service.ClassService;
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
 * @date 2020-12-07 19:03:50
 */
@RestController
@RequestMapping("generator/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:class:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classid}")
    @RequiresPermissions("generator:class:info")
    public R info(@PathVariable("classid") Integer classid){
        ClassEntity classs = classService.getById(classid);

        return R.ok().put("class", classs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:class:save")
    public R save(@RequestBody ClassEntity classs){
		classService.save(classs);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:class:update")
    public R update(@RequestBody ClassEntity classs){
		classService.updateById(classs);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:class:delete")
    public R delete(@RequestBody Integer[] classids){
		classService.removeByIds(Arrays.asList(classids));

        return R.ok();
    }

}
