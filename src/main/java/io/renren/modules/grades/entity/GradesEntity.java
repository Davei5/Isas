package io.renren.modules.grades.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-09 09:45:17
 */
@Data
@TableName("grades")
public class GradesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 成绩id
	 */
	@TableId
	private Integer graid;
	/**
	 * 学生id
	 */
	private String stuid;
	/**
	 * 智育成绩分
	 */
	private Integer intellectually;
	/**
	 * 思想道德素质分
	 */
	private Integer sxddsz;
	/**
	 * 身体素质分
	 */
	private Integer physically;
	/**
	 * 日常行为规范分
	 */
	private Integer rcxwgf;
	/**
	 * 发展性素质
	 */
	private Integer developmental;
	/**
	 * 综合测评成绩
	 */
	private Double zhcp;
	/**
	 * 该成绩所属学期
	 */
	private String time;


}
