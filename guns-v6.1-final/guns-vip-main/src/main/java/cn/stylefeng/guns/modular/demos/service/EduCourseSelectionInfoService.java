package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCourseSelectionInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduCourseSelectionInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCourseSelectionInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 选课信息表 服务类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduCourseSelectionInfoService extends IService<EduCourseSelectionInfo> {

    /**
     * 新增
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void add(EduCourseSelectionInfoParam param);

    /**
     * 删除
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void delete(EduCourseSelectionInfoParam param);

    /**
     * 更新
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void update(EduCourseSelectionInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    EduCourseSelectionInfoResult findBySpec(EduCourseSelectionInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduCourseSelectionInfoResult> findListBySpec(EduCourseSelectionInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
     LayuiPageInfo findPageBySpec(EduCourseSelectionInfoParam param);

}
