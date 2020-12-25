package io.renren.modules.grades.entity;

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
 * @date 2020-12-16 16:20:55
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
	private Double intellectually;
	/**
	 * 思想道德素质分
	 */
	private Double thoughts;
	/**
	 * 身体素质分
	 */
	private Double physically;
	/**
	 * 日常行为规范分
	 */
	private Double dailybehavior;
	/**
	 * 学术与创新
	 */
	private Double academic;
	/**
	 * 实践与服务
	 */
	private Double practice;
	/**
	 * 社会工作
	 */
	private Double socialwork;
	/**
	 * 文体活动
	 */
	private Double culturalandsportsactivities;
	/**
	 * 综合测评成绩
	 */
	private Double synthesis;
	/**
	 * 该成绩所属学期
	 */
	private String semesters;

}
