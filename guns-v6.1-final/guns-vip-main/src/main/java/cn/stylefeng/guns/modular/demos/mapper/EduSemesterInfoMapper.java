package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.EduSemesterInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduSemesterInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduSemesterInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学期信息表 Mapper 接口
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduSemesterInfoMapper extends BaseMapper<EduSemesterInfo> {

    /**
     * 获取列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduSemesterInfoResult> customList(@Param("paramCondition") EduSemesterInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EduSemesterInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<EduSemesterInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") EduSemesterInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EduSemesterInfoParam paramCondition);

}
