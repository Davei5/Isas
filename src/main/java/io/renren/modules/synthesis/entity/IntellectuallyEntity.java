package io.renren.modules.synthesis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 德育表 实体类
 */
@Data
@TableName("intellectually")
public class IntellectuallyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;
    /**
     * 学生id
     */
    private String stuid;

    /**
     * 自评分
     */
    private Double self;

    /**
     * 小组测评分
     */
    private Double smallgroup;

    /**
     * 小组测评分计数
     */
    private Integer countgroup;
}
