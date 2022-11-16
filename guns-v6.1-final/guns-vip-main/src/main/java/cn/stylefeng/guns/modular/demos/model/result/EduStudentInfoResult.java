package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduStudentInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    private String schoolId;

    /**
     * 大学编号
     */
    private String universityId;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String classAndGrade;

    /**
     * 专业
     */
    private String majors;

    private String classRepresentative;

    private Integer markSigninLimits;

    private Date modifyTime;

    private String avatarUrl;

    /**
     * 学生邮箱
     */
    private String studentEmail;

}
