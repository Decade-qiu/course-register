package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCurriculumInfo;
import cn.stylefeng.guns.modular.demos.mapper.EduCurriculumInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduCurriculumInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCurriculumInfoResult;
import  cn.stylefeng.guns.modular.demos.service.EduCurriculumInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 课程信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduCurriculumInfoServiceImpl extends ServiceImpl<EduCurriculumInfoMapper, EduCurriculumInfo> implements EduCurriculumInfoService {

    @Override
    public void add(EduCurriculumInfoParam param){
        EduCurriculumInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduCurriculumInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduCurriculumInfoParam param){
        EduCurriculumInfo oldEntity = getOldEntity(param);
        EduCurriculumInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduCurriculumInfoResult findBySpec(EduCurriculumInfoParam param){
        return null;
    }

    @Override
    public List<EduCurriculumInfoResult> findListBySpec(EduCurriculumInfoParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduCurriculumInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduCurriculumInfoParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduCurriculumInfo getOldEntity(EduCurriculumInfoParam param) {
        return this.getById(getKey(param));
    }

    private EduCurriculumInfo getEntity(EduCurriculumInfoParam param) {
        EduCurriculumInfo entity = new EduCurriculumInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
