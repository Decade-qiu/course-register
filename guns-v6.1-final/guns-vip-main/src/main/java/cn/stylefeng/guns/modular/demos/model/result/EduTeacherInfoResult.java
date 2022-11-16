package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 教师信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduTeacherInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    /**
     * 学院
     */
    private String schoolId;

    /**
     * 大学
     */
    private String universityId;

    /**
     * 教师编号
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教授课程
     */
    private String curriculums;

    private String openId;

    private String unionId;

    /**
     * 教师邮箱
     */
    private String teacherEmail;

}
