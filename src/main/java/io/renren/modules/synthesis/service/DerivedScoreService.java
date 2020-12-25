package io.renren.modules.synthesis.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 实现将成绩以Excel 表格的方式导出
 */
public interface DerivedScoreService {

    HSSFWorkbook downloadScore();
}
