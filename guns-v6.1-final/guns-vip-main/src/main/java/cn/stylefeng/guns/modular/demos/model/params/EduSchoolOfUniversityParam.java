package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class EduSchoolOfUniversityParam implements Serializable, BaseValidatingParam {

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

    @Override
    public String checkParam() {
        return null;
    }

}
