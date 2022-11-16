package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduStudentInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduStudentInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduStudentInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
public interface EduStudentInfoService extends IService<EduStudentInfo> {

    /**
     * 新增
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void add(EduStudentInfoParam param);

    /**
     * 删除
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void delete(EduStudentInfoParam param);

    /**
     * 更新
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    void update(EduStudentInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    EduStudentInfoResult findBySpec(EduStudentInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    List<EduStudentInfoResult> findListBySpec(EduStudentInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
     LayuiPageInfo findPageBySpec(EduStudentInfoParam param);

}
