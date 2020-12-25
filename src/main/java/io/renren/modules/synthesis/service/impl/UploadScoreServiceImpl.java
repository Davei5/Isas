package io.renren.modules.synthesis.service.impl;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.synthesis.mapper.SynthesisMapper;
import io.renren.modules.synthesis.service.UploadScoreService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 上传文件添加成绩的实现类
 */
@Service
@Transactional(readOnly = true)     //只读事务：在将事务设置成只读后，相当于将数据库设置成只读数据库，此时若要进行写的操作，会出现错误
public class UploadScoreServiceImpl implements UploadScoreService {

    @Autowired
    private SynthesisMapper synthesisMapper;

    /**
     * 添加智育、体侧成绩
     * 通过Excel文件 添加
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {

        boolean notNull = false;
        List<GradesEntity> gradesEntityList = new ArrayList<GradesEntity>();

        //matches检测字符串是否匹配给定的正则表达式

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")){
            throw new RuntimeException("上传文件格式不正确");
        }
        boolean isExcel2003= true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        GradesEntity gradesEntity;
        for (int r =1; r <= sheet.getLastRowNum(); r++){
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            gradesEntity = new GradesEntity();

            //获取单元格
            Cell cell = row.getCell(0);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            //获取单元格数据
            String stuid = cell.getStringCellValue();

            if(stuid == null || stuid.isEmpty()){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,学号未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String intellectually = row.getCell(1).getStringCellValue();
            if(intellectually==null || intellectually.isEmpty()){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,智育未填写)");
            }
            double intellectuallyInt = Double.parseDouble(intellectually);

            //获取单元格
            Cell cell2 = row.getCell(2);
            //设置单元格类型
            cell2.setCellType(CellType.STRING);
            //获取单元格数据
            String physically = cell2.getStringCellValue();

            if(physically==null){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,体侧成绩未填写)");
            }
            double physicallyInt = Double.parseDouble(physically);

            gradesEntity.setStuid(stuid);
            gradesEntity.setIntellectually(intellectuallyInt);
            gradesEntity.setPhysically(physicallyInt);

            gradesEntityList.add(gradesEntity);
        }
        for (GradesEntity gradesResord : gradesEntityList) {
            String stuid = gradesResord.getStuid();
            int cnt = synthesisMapper.findByStuid(stuid);

            if (cnt == 0) {
                synthesisMapper.addIntellectually(gradesResord);
                System.out.println(" 插入 "+gradesResord);
            } else {
                synthesisMapper.updateByStuid(gradesResord);
                System.out.println(" 更新 "+gradesResord);
            }
        }
        return notNull;
    }
}
