package cn.stylefeng.guns.gen.modular.service;

import cn.stylefeng.guns.base.db.entity.DatabaseInfo;
import cn.stylefeng.guns.base.db.model.TableFieldInfo;
import cn.stylefeng.guns.base.db.service.DatabaseInfoService;
import cn.stylefeng.guns.base.db.util.DbUtil;
import cn.stylefeng.guns.gen.core.enums.GenSessionKeyFlags;
import cn.stylefeng.guns.gen.modular.model.FieldConfig;
import cn.stylefeng.guns.gen.modular.model.GenSessionFieldConfigs;
import cn.stylefeng.guns.gen.modular.model.params.SaveFieldConfigParam;
import cn.stylefeng.roses.core.util.HttpContext;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.validator.stereotype.ParamValidator;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 代码生成相关逻辑
 *
 * @author fengshuonan
 * @date 2019-05-06-19:04
 */
@Service
public class GenerateService {

    /**
     * 获取某个db容器下，某个表的字段配置
     * <p>
     * 如果之前设置过，则从缓存中拿出
     *
     * @author fengshuonan
     * @Date 2020/1/23 10:54 下午
     */
    public List<FieldConfig> getTableFieldsConfig(Long dbId, String tableName) {

        //查询session中有无已配置的字段数据，有配置过的直接返回
        HttpSession session = HttpContext.getRequest().getSession();
        GenSessionFieldConfigs sessionFieldConfigs = (GenSessionFieldConfigs) session.getAttribute(GenSessionKeyFlags.TABLE_FIELD_STYLES.name());
        if (sessionFieldConfigs != null && sessionFieldConfigs.containConfigFlag(tableName)) {
            return sessionFieldConfigs.getFieldConfigs(tableName);
        }

        //查找数据库元数据信息
        DatabaseInfoService databaseInfoService = null;
        try {
            databaseInfoService = SpringContextHolder.getBean(DatabaseInfoService.class);
        } catch (Exception e) {
            throw new ServiceException(500, "请先开启数据源容器模块！");
        }
        DatabaseInfo databaseInfo = databaseInfoService.getById(dbId);

        //获取对应表的所有字段
        List<TableFieldInfo> tableFields = DbUtil.getTableFields(databaseInfo, tableName);

        //将表的所有字段信息转化为配置信息
        return tableFields.stream().map(i -> {
            FieldConfig fieldConfig = new FieldConfig();
            ToolUtil.copyProperties(i, fieldConfig);
            return fieldConfig;
        }).collect(Collectors.toList());
    }

    /**
     * 设置表的字段配置
     *
     * @author fengshuonan
     * @Date 2020/1/23 11:04 下午
     */
    @ParamValidator
    public void setTableFieldsConfig(SaveFieldConfigParam saveFieldConfigParam) {

        //从session获取配置
        HttpSession session = HttpContext.getRequest().getSession();
        GenSessionFieldConfigs sessionFieldConfigs = (GenSessionFieldConfigs) session.getAttribute(GenSessionKeyFlags.TABLE_FIELD_STYLES.name());
        if (sessionFieldConfigs == null) {
            sessionFieldConfigs = new GenSessionFieldConfigs();
        }

        //放入session配置树形
        sessionFieldConfigs.getFieldConfigs().put(
                saveFieldConfigParam.getTableName(),
                saveFieldConfigParam.getFieldConfigList());

        session.setAttribute(GenSessionKeyFlags.TABLE_FIELD_STYLES.name(), sessionFieldConfigs);
    }

}
