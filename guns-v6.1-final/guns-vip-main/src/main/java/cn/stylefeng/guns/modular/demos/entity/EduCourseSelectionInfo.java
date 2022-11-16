package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 选课信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_course_selection_info")
public class EduCourseSelectionInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    /**
     * 大学
     */
    @TableField("university_id")
    private String universityId;

    /**
     * 学院
     */
    @TableField("school_id")
    private String schoolId;

    /**
     * 学期
     */
    @TableField("semester_id")
    private String semesterId;

    /**
     * 课程编号
     */
    @TableField("curriculum_id")
    private String curriculumId;

    /**
     * 课程名称
     */
    @TableField("curriculum_name")
    private String curriculumName;

    /**
     * 学号
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 学生姓名
     */
    @TableField("student_name")
    private String studentName;

    /**
     * 教师编号
     */
    @TableField("teacher_id")
    private String teacherId;

    /**
     * 教师姓名
     */
    @TableField("teacher_name")
    private String teacherName;

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

    /**
     * 上课时间
     */
    @TableField("time_for_class")
    private String timeForClass;

    /**
     * 教室
     */
    @TableField("classroom")
    private String classroom;

    /**
     * 年级
     */
    @TableField("grade")
    private String grade;

    /**
     * 班级
     */
    @TableField("class_and_grade")
    private String classAndGrade;

    /**
     * 主修专业
     */
    @TableField("majors")
    private String majors;

    /**
     * 学院名
     */
    @TableField("school_name")
    private String schoolName;

    /**
     * 导入时间
     */
    @TableField("import_time")
    private Date importTime;

    /**
     * 有效状态
     */
    @TableField("status")
    private Integer status;

    @TableField("memo")
    private String memo;


    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassAndGrade() {
        return classAndGrade;
    }

    public void setClassAndGrade(String classAndGrade) {
        this.classAndGrade = classAndGrade;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "EduCourseSelectionInfo{" +
        "uniqueKey=" + uniqueKey +
        ", universityId=" + universityId +
        ", schoolId=" + schoolId +
        ", semesterId=" + semesterId +
        ", curriculumId=" + curriculumId +
        ", curriculumName=" + curriculumName +
        ", studentId=" + studentId +
        ", studentName=" + studentName +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", creditHour=" + creditHour +
        ", curriculumType=" + curriculumType +
        ", timeForClass=" + timeForClass +
        ", classroom=" + classroom +
        ", grade=" + grade +
        ", classAndGrade=" + classAndGrade +
        ", majors=" + majors +
        ", schoolName=" + schoolName +
        ", importTime=" + importTime +
        ", status=" + status +
        ", memo=" + memo +
        "}";
    }
}
