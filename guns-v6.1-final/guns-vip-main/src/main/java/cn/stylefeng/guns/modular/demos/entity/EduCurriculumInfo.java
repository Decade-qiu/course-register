package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_curriculum_info")
public class EduCurriculumInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    /**
     * 学院编号
     */
    @TableField("school_id")
    private String schoolId;

    /**
     * 大学编号
     */
    @TableField("university_id")
    private String universityId;

    /**
     * 课程编号
     */
    @TableField("curriculum_id")
    private String curriculumId;

    /**
     * 课程名
     */
    @TableField("curriculum_name")
    private String curriculumName;

    @TableField("curriculum_english_name")
    private String curriculumEnglishName;

    /**
     * 上课老师
     */
    @TableField("teachers")
    private String teachers;

    /**
     * 上课地点
     */
    @TableField("classrooms")
    private String classrooms;

    /**
     * 学分
     */
    @TableField("credit_hour")
    private Float creditHour;

    /**
     * 课程分类
     */
    @TableField("curriculum_type")
    private String curriculumType;

    @TableField("time_for_class")
    private String timeForClass;

    /**
     * 学期
     */
    @TableField("semester_id")
    private String semesterId;

    @TableField("teacher_id")
    private String teacherId;

    @TableField("need_signin")
    private String needSignin;

    @TableField("course_select_num")
    private Integer courseSelectNum;


    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumEnglishName() {
        return curriculumEnglishName;
    }

    public void setCurriculumEnglishName(String curriculumEnglishName) {
        this.curriculumEnglishName = curriculumEnglishName;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(String classrooms) {
        this.classrooms = classrooms;
    }

    public Float getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(Float creditHour) {
        this.creditHour = creditHour;
    }

    public String getCurriculumType() {
        return curriculumType;
    }

    public void setCurriculumType(String curriculumType) {
        this.curriculumType = curriculumType;
    }

    public String getTimeForClass() {
        return timeForClass;
    }

    public void setTimeForClass(String timeForClass) {
        this.timeForClass = timeForClass;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getNeedSignin() {
        return needSignin;
    }

    public void setNeedSignin(String needSignin) {
        this.needSignin = needSignin;
    }

    public Integer getCourseSelectNum() {
        return courseSelectNum;
    }

    public void setCourseSelectNum(Integer courseSelectNum) {
        this.courseSelectNum = courseSelectNum;
    }

    @Override
    public String toString() {
        return "EduCurriculumInfo{" +
        "uniqueKey=" + uniqueKey +
        ", schoolId=" + schoolId +
        ", universityId=" + universityId +
        ", curriculumId=" + curriculumId +
        ", curriculumName=" + curriculumName +
        ", curriculumEnglishName=" + curriculumEnglishName +
        ", teachers=" + teachers +
        ", classrooms=" + classrooms +
        ", creditHour=" + creditHour +
        ", curriculumType=" + curriculumType +
        ", timeForClass=" + timeForClass +
        ", semesterId=" + semesterId +
        ", teacherId=" + teacherId +
        ", needSignin=" + needSignin +
        ", courseSelectNum=" + courseSelectNum +
        "}";
    }
}
