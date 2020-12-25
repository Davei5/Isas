package io.renren.modules.studentes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-16 16:21:04
 */
@Data
@TableName("student")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	private Integer id;
	/**
	 * 学生id
	 */
	private String stuid;
	/**
	 * 所属班级
	 */
	private String classname;
	/**
	 * 所属系别
	 */
	private String depname;
	/**
	 * 姓名
	 */
	private String stuname;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;

}
