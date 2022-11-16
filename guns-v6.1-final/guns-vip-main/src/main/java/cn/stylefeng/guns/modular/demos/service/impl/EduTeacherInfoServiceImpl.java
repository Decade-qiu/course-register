package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduTeacherInfo;
import cn.stylefeng.guns.modular.demos.mapper.EduTeacherInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduTeacherInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduTeacherInfoResult;
import  cn.stylefeng.guns.modular.demos.service.EduTeacherInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 教师信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduTeacherInfoServiceImpl extends ServiceImpl<EduTeacherInfoMapper, EduTeacherInfo> implements EduTeacherInfoService {

    @Override
    public void add(EduTeacherInfoParam param){
        EduTeacherInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduTeacherInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduTeacherInfoParam param){
        EduTeacherInfo oldEntity = getOldEntity(param);
        EduTeacherInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduTeacherInfoResult findBySpec(EduTeacherInfoParam param){
        return null;
    }

    @Override
    public List<EduTeacherInfoResult> findListBySpec(EduTeacherInfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduTeacherInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduTeacherInfoParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduTeacherInfo getOldEntity(EduTeacherInfoParam param) {
        return this.getById(getKey(param));
    }

    private EduTeacherInfo getEntity(EduTeacherInfoParam param) {
        EduTeacherInfo entity = new EduTeacherInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
