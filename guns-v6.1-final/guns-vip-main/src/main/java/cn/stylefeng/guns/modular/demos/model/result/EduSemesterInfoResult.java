package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
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
public class EduSemesterInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    private String universityId;

    private String schoolId;

    private String semester;

    private Date startDate;

    private Date endDate;

    private Integer weekNum;

    private String memo;

}
