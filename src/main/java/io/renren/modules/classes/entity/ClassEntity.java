package io.renren.modules.classes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * 班级表实体类
 */
@Data
@TableName("class")
public class ClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 班级id
	 */
	@TableId
	private Integer classid;
	/**
	 * 班级名称
	 */
	private String classname;
	/**
	 * 班主任
	 */
	private String hrteacher;
	/**
	 * 所属部门
	 */
	private Integer depid;

}
