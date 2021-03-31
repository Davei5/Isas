package io.renren.modules.synthesis.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 材料提交表 实体类
 */
public class MaterialsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号id
     */
    @TableId
    private Integer id;

    /**
     * 学生id
     */
    private String stuid;

    /**
     * 加分类型
     */
    private Integer types;

    /**
     * 图片材料
     */
    private byte[] images;
}
