package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 院系信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_school_of_university")
public class EduSchoolOfUniversity implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    /**
     * 大学编号
     */
    @TableField("university_id")
    private String universityId;

    @TableField("university_name")
    private String universityName;

    @TableField("school_name")
    private String schoolName;

    @TableField("school_short_name")
    private String schoolShortName;

    @TableField("school_id")
    private String schoolId;


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

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolShortName() {
        return schoolShortName;
    }

    public void setSchoolShortName(String schoolShortName) {
        this.schoolShortName = schoolShortName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "EduSchoolOfUniversity{" +
        "uniqueKey=" + uniqueKey +
        ", universityId=" + universityId +
        ", universityName=" + universityName +
        ", schoolName=" + schoolName +
        ", schoolShortName=" + schoolShortName +
        ", schoolId=" + schoolId +
        "}";
    }
}
