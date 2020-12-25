package io.renren.modules.synthesis.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.modules.studentes.entity.StudentEntity;
import io.renren.modules.synthesis.service.SynthesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test1")
public class SynthesisController {
    @Autowired
    private SynthesisService synthesisService;

    @RequestMapping("/list")
    public String listSelClassStu(String stuId, Model model, @RequestParam(value = "start",defaultValue = "0")
            int start, @RequestParam(value = "size",defaultValue = "10") int size){
        PageHelper.startPage(start,size,"id desc");
        List<StudentEntity> stus = synthesisService.selClassNameStu(stuId);
        PageInfo<StudentEntity> page = new PageInfo<>(stus);
        model.addAttribute("page",page);
        return "list";
    }
}
