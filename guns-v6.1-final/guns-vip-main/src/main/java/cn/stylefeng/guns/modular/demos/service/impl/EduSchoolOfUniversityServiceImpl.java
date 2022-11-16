package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSchoolOfUniversity;
import cn.stylefeng.guns.modular.demos.mapper.EduSchoolOfUniversityMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduSchoolOfUniversityParam;
import cn.stylefeng.guns.modular.demos.model.result.EduSchoolOfUniversityResult;
import  cn.stylefeng.guns.modular.demos.service.EduSchoolOfUniversityService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 院系信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduSchoolOfUniversityServiceImpl extends ServiceImpl<EduSchoolOfUniversityMapper, EduSchoolOfUniversity> implements EduSchoolOfUniversityService {

    @Override
    public void add(EduSchoolOfUniversityParam param){
        EduSchoolOfUniversity entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduSchoolOfUniversityParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduSchoolOfUniversityParam param){
        EduSchoolOfUniversity oldEntity = getOldEntity(param);
        EduSchoolOfUniversity newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduSchoolOfUniversityResult findBySpec(EduSchoolOfUniversityParam param){
        return null;
    }

    @Override
    public List<EduSchoolOfUniversityResult> findListBySpec(EduSchoolOfUniversityParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduSchoolOfUniversityParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduSchoolOfUniversityParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduSchoolOfUniversity getOldEntity(EduSchoolOfUniversityParam param) {
        return this.getById(getKey(param));
    }

    private EduSchoolOfUniversity getEntity(EduSchoolOfUniversityParam param) {
        EduSchoolOfUniversity entity = new EduSchoolOfUniversity();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
