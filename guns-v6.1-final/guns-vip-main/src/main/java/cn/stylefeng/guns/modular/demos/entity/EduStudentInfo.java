package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_student_info")
public class EduStudentInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    @TableField("school_id")
    private String schoolId;

    /**
     * 大学编号
     */
    @TableField("university_id")
    private String universityId;

    /**
     * 学号
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 姓名
     */
    @TableField("student_name")
    private String studentName;

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
     * 专业
     */
    @TableField("majors")
    private String majors;

    @TableField("class_representative")
    private String classRepresentative;

    @TableField("mark_signin_limits")
    private Integer markSigninLimits;

    @TableField("modify_time")
    private Date modifyTime;

    @TableField("avatar_url")
    private String avatarUrl;

    /**
     * 学生邮箱
     */
    @TableField("student_email")
    private String studentEmail;


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

    public String getClassRepresentative() {
        return classRepresentative;
    }

    public void setClassRepresentative(String classRepresentative) {
        this.classRepresentative = classRepresentative;
    }

    public Integer getMarkSigninLimits() {
        return markSigninLimits;
    }

    public void setMarkSigninLimits(Integer markSigninLimits) {
        this.markSigninLimits = markSigninLimits;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "EduStudentInfo{" +
        "uniqueKey=" + uniqueKey +
        ", schoolId=" + schoolId +
        ", universityId=" + universityId +
        ", studentId=" + studentId +
        ", studentName=" + studentName +
        ", grade=" + grade +
        ", classAndGrade=" + classAndGrade +
        ", majors=" + majors +
        ", classRepresentative=" + classRepresentative +
        ", markSigninLimits=" + markSigninLimits +
        ", modifyTime=" + modifyTime +
        ", avatarUrl=" + avatarUrl +
        ", studentEmail=" + studentEmail +
        "}";
    }
}
