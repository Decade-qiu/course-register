package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.EduCourseSelectionInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduCourseSelectionInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCourseSelectionInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 选课信息表 Mapper 接口
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduCourseSelectionInfoMapper extends BaseMapper<EduCourseSelectionInfo> {

    /**
     * 获取列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduCourseSelectionInfoResult> customList(@Param("paramCondition") EduCourseSelectionInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EduCourseSelectionInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<EduCourseSelectionInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") EduCourseSelectionInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EduCourseSelectionInfoParam paramCondition);

}
