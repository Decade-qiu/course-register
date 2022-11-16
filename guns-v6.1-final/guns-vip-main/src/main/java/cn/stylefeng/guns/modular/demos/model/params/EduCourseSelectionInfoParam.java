package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 选课信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduCourseSelectionInfoParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    /**
     * 大学
     */
    private String universityId;

    /**
     * 学院
     */
    private String schoolId;

    /**
     * 学期
     */
    private String semesterId;

    /**
     * 课程编号
     */
    private String curriculumId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 教师编号
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 学分
     */
    private Float creditHour;

    /**
     * 课程分类
     */
    private String curriculumType;

    /**
     * 上课时间
     */
    private String timeForClass;

    /**
     * 教室
     */
    private String classroom;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String classAndGrade;

    /**
     * 主修专业
     */
    private String majors;

    /**
     * 学院名
     */
    private String schoolName;

    /**
     * 导入时间
     */
    private Date importTime;

    /**
     * 有效状态
     */
    private Integer status;

    private String memo;

    @Override
    public String checkParam() {
        return null;
    }

}
