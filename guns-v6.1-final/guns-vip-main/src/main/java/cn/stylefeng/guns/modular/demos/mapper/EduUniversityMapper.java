package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.EduUniversity;
import cn.stylefeng.guns.modular.demos.model.params.EduUniversityParam;
import cn.stylefeng.guns.modular.demos.model.result.EduUniversityResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 大学信息表 Mapper 接口
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduUniversityMapper extends BaseMapper<EduUniversity> {

    /**
     * 获取列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduUniversityResult> customList(@Param("paramCondition") EduUniversityParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EduUniversityParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<EduUniversityResult> customPageList(@Param("page") Page page, @Param("paramCondition") EduUniversityParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EduUniversityParam paramCondition);

}
