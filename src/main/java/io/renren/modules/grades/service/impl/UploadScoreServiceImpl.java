package io.renren.modules.grades.service.impl;

import io.renren.modules.grades.entity.GradesEntity;
import io.renren.modules.grades.mapper.GradesMapper;
import io.renren.modules.grades.service.UploadScoreService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)     //只读事务：在将事务设置成只读后，相当于将数据库设置成只读数据库，此时若要进行写的操作，会出现错误
public class UploadScoreServiceImpl implements UploadScoreService {

    @Autowired
    private GradesMapper gradesMapper;

    /**
     * 添加智育成绩
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

            if( row.getCell(0).getCellType() !=1){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,学号请设为文本格式)");
            }
            String stuid = row.getCell(0).getStringCellValue();

            if(stuid == null || stuid.isEmpty()){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,学号未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String intellectually = row.getCell(1).getStringCellValue();
            if(intellectually==null || intellectually.isEmpty()){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,智育未填写)");
            }
            int intellectuallyInt = Integer.parseInt(intellectually);
            String physically = row.getCell(2).getStringCellValue();
            if(physically==null){
                throw new RuntimeException("导入失败(第"+(r+1)+"行,体侧成绩未填写)");
            }
            int physicallyInt = Integer.parseInt(physically);

            gradesEntity.setStuid(stuid);
            gradesEntity.setIntellectually(intellectuallyInt);
            gradesEntity.setPhysically(physicallyInt);

            gradesEntityList.add(gradesEntity);
        }
        for (GradesEntity gradesResord : gradesEntityList) {
            String stuid = gradesResord.getStuid();
            int cnt = gradesMapper.findByStuid(stuid);
            if (cnt == 0) {
                gradesMapper.addIntellectually(gradesResord);
                System.out.println(" 插入 "+gradesResord);
            } else {
                gradesMapper.updateByName(gradesResord);
                System.out.println(" 更新 "+gradesMapper);
            }
        }
        return notNull;
    }
}
