package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 学期信息表
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Data
public class EduSemesterInfoParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    private String universityId;

    private String schoolId;

    private String semester;

    private Date startDate;

    private Date endDate;

    private Integer weekNum;

    private String memo;

    @Override
    public String checkParam() {
        return null;
    }

}
