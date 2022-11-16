package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduUniversity;
import cn.stylefeng.guns.modular.demos.mapper.EduUniversityMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduUniversityParam;
import cn.stylefeng.guns.modular.demos.model.result.EduUniversityResult;
import  cn.stylefeng.guns.modular.demos.service.EduUniversityService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 大学信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduUniversityServiceImpl extends ServiceImpl<EduUniversityMapper, EduUniversity> implements EduUniversityService {

    @Override
    public void add(EduUniversityParam param){
        EduUniversity entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduUniversityParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduUniversityParam param){
        EduUniversity oldEntity = getOldEntity(param);
        EduUniversity newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduUniversityResult findBySpec(EduUniversityParam param){
        return null;
    }

    @Override
    public List<EduUniversityResult> findListBySpec(EduUniversityParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduUniversityParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduUniversityParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduUniversity getOldEntity(EduUniversityParam param) {
        return this.getById(getKey(param));
    }

    private EduUniversity getEntity(EduUniversityParam param) {
        EduUniversity entity = new EduUniversity();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
