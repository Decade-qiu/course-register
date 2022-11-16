package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduStudentInfo;
import cn.stylefeng.guns.modular.demos.mapper.EduStudentInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.EduStudentInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduStudentInfoResult;
import  cn.stylefeng.guns.modular.demos.service.EduStudentInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author Frey Wang
 * @since 2022-11-09
 */
@Service
public class EduStudentInfoServiceImpl extends ServiceImpl<EduStudentInfoMapper, EduStudentInfo> implements EduStudentInfoService {

    @Override
    public void add(EduStudentInfoParam param){
        EduStudentInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(EduStudentInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(EduStudentInfoParam param){
        EduStudentInfo oldEntity = getOldEntity(param);
        EduStudentInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EduStudentInfoResult findBySpec(EduStudentInfoParam param){
        return null;
    }

    @Override
    public List<EduStudentInfoResult> findListBySpec(EduStudentInfoParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(EduStudentInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EduStudentInfoParam param){
        return param.getUniqueKey();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EduStudentInfo getOldEntity(EduStudentInfoParam param) {
        return this.getById(getKey(param));
    }

    private EduStudentInfo getEntity(EduStudentInfoParam param) {
        EduStudentInfo entity = new EduStudentInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
