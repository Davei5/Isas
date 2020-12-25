package io.renren.modules.synthesis.service.impl;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.synthesis.mapper.SynthesisMapper;
import io.renren.modules.synthesis.service.DerivedScoreService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 下载成绩Excel的实现类
 */
@Service
public class DerivedScoreServiceImpl implements DerivedScoreService {

    @Autowired
    private SynthesisMapper synthesisMapper;

    /**
     * 下载成绩表
     * 通过 Excel 输出
     * @return
     */
    @Override
    public HSSFWorkbook downloadScore() {

        /*List<GradesEntity> list = synthesisMapper.findByClassName(String stuid);
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //1.1创建合并单元格对象
        CellRangeAddress callRangeAddress = new CellRangeAddress(0,0,0,17);//起始行,结束行,起始列,结束列
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("成绩表");
        // 第三步，在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //声明列对象
        HSSFCell cell = null;*/




        return null;

    }
}
