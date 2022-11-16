package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSemesterInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduSemesterInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduSemesterInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学期信息表 服务类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduSemesterInfoService extends IService<EduSemesterInfo> {

    /**
     * 新增
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void add(EduSemesterInfoParam param);

    /**
     * 删除
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void delete(EduSemesterInfoParam param);

    /**
     * 更新
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void update(EduSemesterInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    EduSemesterInfoResult findBySpec(EduSemesterInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduSemesterInfoResult> findListBySpec(EduSemesterInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
     LayuiPageInfo findPageBySpec(EduSemesterInfoParam param);

}
