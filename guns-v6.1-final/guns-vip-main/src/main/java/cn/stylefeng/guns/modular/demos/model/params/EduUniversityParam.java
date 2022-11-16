package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 大学信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduUniversityParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    private String curriculumId;

    private String curriculumName;

    private String studentId;

    private String studentName;

    private Date reTime;

    public EduUniversityParam(String uniqueKey, String curriculumId, String curriculumName, String studentId, String studentName, Date reTime) {
        this.uniqueKey = uniqueKey;
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.reTime = reTime;
    }

    @Override
    public String checkParam() {
        return null;
    }

}
