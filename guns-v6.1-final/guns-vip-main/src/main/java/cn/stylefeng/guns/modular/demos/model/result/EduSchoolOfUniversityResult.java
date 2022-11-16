package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 院系信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduSchoolOfUniversityResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    /**
     * 大学编号
     */
    private String universityId;

    private String universityName;

    private String schoolName;

    private String schoolShortName;

    private String schoolId;

}
