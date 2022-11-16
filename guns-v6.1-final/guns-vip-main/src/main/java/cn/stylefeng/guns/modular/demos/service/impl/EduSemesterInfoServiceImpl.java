package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSemesterInfo;
import cn.stylefeng.guns.modular.demos.mapper.EduSemesterInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduSemesterInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduSemesterInfoResult;
import  cn.stylefeng.guns.modular.demos.service.EduSemesterInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 学期信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduSemesterInfoServiceImpl extends ServiceImpl<EduSemesterInfoMapper, EduSemesterInfo> implements EduSemesterInfoService {

    @Override
    public void add(EduSemesterInfoParam param){
        EduSemesterInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduSemesterInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduSemesterInfoParam param){
        EduSemesterInfo oldEntity = getOldEntity(param);
        EduSemesterInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduSemesterInfoResult findBySpec(EduSemesterInfoParam param){
        return null;
    }

    @Override
    public List<EduSemesterInfoResult> findListBySpec(EduSemesterInfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduSemesterInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduSemesterInfoParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduSemesterInfo getOldEntity(EduSemesterInfoParam param) {
        return this.getById(getKey(param));
    }

    private EduSemesterInfo getEntity(EduSemesterInfoParam param) {
        EduSemesterInfo entity = new EduSemesterInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
