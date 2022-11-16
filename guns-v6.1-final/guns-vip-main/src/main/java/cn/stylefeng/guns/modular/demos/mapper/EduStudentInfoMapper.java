package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.EduStudentInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduStudentInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduStudentInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduStudentInfoMapper extends BaseMapper<EduStudentInfo> {

    /**
     * 获取列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduStudentInfoResult> customList(@Param("paramCondition") EduStudentInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EduStudentInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<EduStudentInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") EduStudentInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EduStudentInfoParam paramCondition);

}
