package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCurriculumInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduCurriculumInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCurriculumInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程信息表 服务类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduCurriculumInfoService extends IService<EduCurriculumInfo> {

    /**
     * 新增
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void add(EduCurriculumInfoParam param);

    /**
     * 删除
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void delete(EduCurriculumInfoParam param);

    /**
     * 更新
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void update(EduCurriculumInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    EduCurriculumInfoResult findBySpec(EduCurriculumInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduCurriculumInfoResult> findListBySpec(EduCurriculumInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
     LayuiPageInfo findPageBySpec(EduCurriculumInfoParam param);

}
