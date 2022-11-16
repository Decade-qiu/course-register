package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 学期信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@TableName("edu_semester_info")
public class EduSemesterInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "unique_key", type = IdType.ID_WORKER)
    private String uniqueKey;

    @TableField("university_id")
    private String universityId;

    @TableField("school_id")
    private String schoolId;

    @TableField("semester")
    private String semester;

    @TableField("start_date")
    private Date startDate;

    @TableField("end_date")
    private Date endDate;

    @TableField("week_num")
    private Integer weekNum;

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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "EduSemesterInfo{" +
        "uniqueKey=" + uniqueKey +
        ", universityId=" + universityId +
        ", schoolId=" + schoolId +
        ", semester=" + semester +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", weekNum=" + weekNum +
        ", memo=" + memo +
        "}";
    }
}
