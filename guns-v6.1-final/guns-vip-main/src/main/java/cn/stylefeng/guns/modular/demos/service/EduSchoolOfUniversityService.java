package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSchoolOfUniversity;
import cn.stylefeng.guns.modular.demos.model.params.EduSchoolOfUniversityParam;
import cn.stylefeng.guns.modular.demos.model.result.EduSchoolOfUniversityResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 院系信息表 服务类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduSchoolOfUniversityService extends IService<EduSchoolOfUniversity> {

    /**
     * 新增
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void add(EduSchoolOfUniversityParam param);

    /**
     * 删除
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void delete(EduSchoolOfUniversityParam param);

    /**
     * 更新
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void update(EduSchoolOfUniversityParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    EduSchoolOfUniversityResult findBySpec(EduSchoolOfUniversityParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduSchoolOfUniversityResult> findListBySpec(EduSchoolOfUniversityParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
     LayuiPageInfo findPageBySpec(EduSchoolOfUniversityParam param);

}
