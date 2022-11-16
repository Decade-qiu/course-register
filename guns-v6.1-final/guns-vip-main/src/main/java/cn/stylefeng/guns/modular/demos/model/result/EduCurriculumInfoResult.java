package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduCurriculumInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    /**
     * 学院编号
     */
    private String schoolId;

    /**
     * 大学编号
     */
    private String universityId;

    /**
     * 课程编号
     */
    private String curriculumId;

    /**
     * 课程名
     */
    private String curriculumName;

    private String curriculumEnglishName;

    /**
     * 上课老师
     */
    private String teachers;

    /**
     * 上课地点
     */
    private String classrooms;

    /**
     * 学分
     */
    private Float creditHour;

    /**
     * 课程分类
     */
    private String curriculumType;

    private String timeForClass;

    /**
     * 学期
     */
    private String semesterId;

    private String teacherId;

    private String needSignin;

    private Integer courseSelectNum;

}
