package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
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
public class EduUniversityResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String uniqueKey;

    private String curriculumId;

    private String curriculumName;

    private String studentId;

    private String studentName;

    private Date reTime;

}
