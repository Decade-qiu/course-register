package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCourseSelectionInfo;
import cn.stylefeng.guns.modular.demos.mapper.EduCourseSelectionInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduCourseSelectionInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCourseSelectionInfoResult;
import  cn.stylefeng.guns.modular.demos.service.EduCourseSelectionInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 选课信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduCourseSelectionInfoServiceImpl extends ServiceImpl<EduCourseSelectionInfoMapper, EduCourseSelectionInfo> implements EduCourseSelectionInfoService {

    @Override
    public void add(EduCourseSelectionInfoParam param){
        EduCourseSelectionInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduCourseSelectionInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduCourseSelectionInfoParam param){
        EduCourseSelectionInfo oldEntity = getOldEntity(param);
        EduCourseSelectionInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduCourseSelectionInfoResult findBySpec(EduCourseSelectionInfoParam param){
        return null;
    }

    @Override
    public List<EduCourseSelectionInfoResult> findListBySpec(EduCourseSelectionInfoParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduCourseSelectionInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduCourseSelectionInfoParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduCourseSelectionInfo getOldEntity(EduCourseSelectionInfoParam param) {
        return this.getById(getKey(param));
    }

    private EduCourseSelectionInfo getEntity(EduCourseSelectionInfoParam param) {
        EduCourseSelectionInfo entity = new EduCourseSelectionInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
