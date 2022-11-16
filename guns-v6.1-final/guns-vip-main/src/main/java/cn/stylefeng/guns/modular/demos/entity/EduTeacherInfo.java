package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 教师信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_teacher_info")
public class EduTeacherInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    /**
     * 学院
     */
    @TableField("school_id")
    private String schoolId;

    /**
     * 大学
     */
    @TableField("university_id")
    private String universityId;

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
     * 教授课程
     */
    @TableField("curriculums")
    private String curriculums;

    @TableField("open_id")
    private String openId;

    @TableField("union_id")
    private String unionId;

    /**
     * 教师邮箱
     */
    @TableField("teacher_email")
    private String teacherEmail;


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

    public String getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(String curriculums) {
        this.curriculums = curriculums;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @Override
    public String toString() {
        return "EduTeacherInfo{" +
        "uniqueKey=" + uniqueKey +
        ", schoolId=" + schoolId +
        ", universityId=" + universityId +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", curriculums=" + curriculums +
        ", openId=" + openId +
        ", unionId=" + unionId +
        ", teacherEmail=" + teacherEmail +
        "}";
    }
}
