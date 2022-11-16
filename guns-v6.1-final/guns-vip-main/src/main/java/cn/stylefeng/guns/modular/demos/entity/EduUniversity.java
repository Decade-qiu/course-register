package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 大学信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_university")
public class EduUniversity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

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

    @TableField("student_id")
    private String studentId;

    /**
     * 学生姓名
     */
    @TableField("student_name")
    private String studentName;

    @TableField("re_time")
    private Date reTime;

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
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

    public Date getReTime() {
        return reTime;
    }

    public void setReTime(Date reTime) {
        this.reTime = reTime;
    }

    @Override
    public String toString() {
        return "EduUniversity{" +
                "uniqueKey='" + uniqueKey + '\'' +
                ", curriculumId='" + curriculumId + '\'' +
                ", curriculumName='" + curriculumName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", reTime=" + reTime +
                '}';
    }
}
