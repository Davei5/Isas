package io.renren.modules.department.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 系部表 实体类
 */
@Data
@TableName("department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 部门ID
	 */
	@TableId
	private Integer depid;
	/**
	 * 部门名
	 */
	private String depname;

	/**
	 * 部门管理员
	 */
	private String depadmin;
}
