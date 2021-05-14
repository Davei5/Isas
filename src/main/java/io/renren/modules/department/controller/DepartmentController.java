package io.renren.modules.department.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.modules.department.entity.DepartmentEntity;
import io.renren.modules.department.service.DepartmentService;
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
 * 系部表 控制层
 *
 */
@RestController
@RequestMapping("generator/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 按部门名查询
     */
    @RequestMapping("/findByName")
    public R findByName(String name){
        List<DepartmentEntity> pageUtils = departmentService.findByName(name);
        return  R.ok().put("page",pageUtils);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:department:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = departmentService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{depid}")
    @RequiresPermissions("generator:department:info")
    public R info(@PathVariable("depid") Integer depid){
		DepartmentEntity department = departmentService.getById(depid);

        return R.ok().put("department", department);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:department:save")
    public R save(@RequestBody DepartmentEntity department){
		departmentService.save(department);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:department:update")
    public R update(@RequestBody DepartmentEntity department){
		departmentService.updateById(department);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:department:delete")
    public R delete(@RequestBody Integer[] depids){
		departmentService.removeByIds(Arrays.asList(depids));

        return R.ok();
    }

}
