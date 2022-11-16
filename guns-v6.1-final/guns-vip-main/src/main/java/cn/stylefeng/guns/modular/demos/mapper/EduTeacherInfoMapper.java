package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.EduTeacherInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduTeacherInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduTeacherInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师信息表 Mapper 接口
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduTeacherInfoMapper extends BaseMapper<EduTeacherInfo> {

    /**
     * 获取列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduTeacherInfoResult> customList(@Param("paramCondition") EduTeacherInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EduTeacherInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<EduTeacherInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") EduTeacherInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EduTeacherInfoParam paramCondition);

}
