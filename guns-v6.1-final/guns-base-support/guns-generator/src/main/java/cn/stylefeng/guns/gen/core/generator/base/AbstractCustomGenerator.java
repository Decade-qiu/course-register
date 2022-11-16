package cn.stylefeng.guns.gen.core.generator.base;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.gen.core.engine.BeetlEngine;
import cn.stylefeng.guns.gen.core.enums.FilterFieldsEnum;
import cn.stylefeng.guns.gen.core.enums.GenDownloadEnum;
import cn.stylefeng.guns.gen.core.util.FieldsConfigHolder;
import cn.stylefeng.guns.gen.core.util.OsUtil;
import cn.stylefeng.guns.gen.core.util.TemplateUtil;
import cn.stylefeng.guns.gen.modular.model.FieldConfig;
import cn.stylefeng.guns.gen.modular.model.GenSessionFieldConfigs;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.extern.slf4j.Slf4j;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 代码生成器规范
 *
 * @author fengshuonan
 * @date 2018-12-12-2:41 PM
 */
@Slf4j
public abstract class AbstractCustomGenerator extends Generator {

    protected Map<String, Object> tableContext;

    public AbstractCustomGenerator(Map<String, Object> tableContext) {
        this.tableContext = tableContext;
    }

    /**
     * 执行代码生成
     *
     * @author fengshuonan
     * @Date 2018/12/12 3:13 PM
     */
    @Override
    public void doGeneration() {

        //获取beetl模板引擎，初始化模板
        GroupTemplate groupTemplate = BeetlEngine.getInstance();
        Template template = groupTemplate.getTemplate(this.getTemplateResourcePath());

        //绑定默认参数
        template.binding("context", contextParam);

        //获取table的注释，
        TableInfo table = (TableInfo) tableContext.get("table");
        tableContext.put("tableComment", TemplateUtil.cleanWhite(table.getComment()));

        //实体名称的首字母小写的名称
        tableContext.put("lowerEntity", TemplateUtil.lowerFirst((String) tableContext.get("entity")));

        //获取主键的字段名称
        String keyPropertyName = "";
        for (TableField field : table.getFields()) {
            if (field.isKeyFlag()) {
                keyPropertyName = field.getPropertyName();
            }
        }
        tableContext.put("keyPropertyName", keyPropertyName);

        //首字母大写的主键名称
        tableContext.put("bigKeyPropertyName", StrUtil.upperFirst(keyPropertyName));

        //获取新增和修改页面的跳转类型
        Boolean jumpType = contextParam.getJumpTypeMap().get(table.getName());
        tableContext.put("jumpType", jumpType);

        //绑定mp的参数
        template.binding(tableContext);

        //绑定模板参数
        this.bindingOthers(template);

        //获取文件生成的路径(根据代码下载方式的不同，获取不同类型的path)
        String filePath;
        if (GenDownloadEnum.DEFAULT_PATH.equals(contextParam.getGenDownloadEnum())) {
            filePath = getGenerateFileTempPath();
        } else {
            filePath = getGenerateFileDirectPath();
        }

        //执行代码生成
        if (OsUtil.windowsFlag()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            template.renderTo(fileOutputStream);
        } catch (FileNotFoundException e) {
            log.error("代码生成出错！", e);
        } finally {
            IoUtil.close(fileOutputStream);
        }

    }

    /**
     * 绑定参数
     *
     * @author fengshuonan
     * @Date 2018/12/13 9:49 AM
     */
    public void bindingOthers(Template template) {

    }

    /**
     * 绑定添加和修改页面 input框元素 需要的参数
     *
     * @author fengshuonan
     * @Date 2019/1/19 2:18 PM
     */
    public void bindingInputsParams(Template template) {

        TableInfo table = (TableInfo) tableContext.get("table");
        List<TableField> fields = table.getFields();

        //获取表对应的字段配置
        GenSessionFieldConfigs genSessionFieldConfigs = FieldsConfigHolder.get();
        List<FieldConfig> fieldConfigs = genSessionFieldConfigs.getFieldConfigs(table.getName());

        //如果fieldConfigs为空，则填充表的字段
        if (fieldConfigs == null || fieldConfigs.size() == 0) {
            fieldConfigs = fields.stream().map(FieldConfig::getFromTableField).collect(Collectors.toList());
        }

        //获取不需要进行代码生成的字段，例如creat_time这种字段
        List<String> filterFields = FilterFieldsEnum.getFields();

        //去掉主键字段，去掉其他不需要进行代码生成的字段
        ArrayList<FieldConfig> renderFieldConfigs = new ArrayList<>();
        for (TableField field : fields) {
            if (filterFields.contains(field.getName()) || field.isKeyFlag()) {
                continue;
            }
            for (FieldConfig fieldConfig : fieldConfigs) {
                if (fieldConfig.getColumnName().equals(field.getName())) {
                    renderFieldConfigs.add(fieldConfig);
                }
            }
        }

        template.binding("fieldConfigs", renderFieldConfigs);
    }

    /**
     * 绑定查询参数
     *
     * @author stylefeng
     * @date 2020/1/17
     */
    public void bindingConditionParams(Template template) {

        TableInfo table = (TableInfo) tableContext.get("table");

        //获取表对应的字段配置
        GenSessionFieldConfigs genSessionFieldConfigs = FieldsConfigHolder.get();
        List<FieldConfig> fieldConfigs = genSessionFieldConfigs.getFieldConfigs(table.getName());

        //查找并过滤出带条件的字段
        List<FieldConfig> conditionFields = fieldConfigs.stream()
                .filter(FieldConfig::getQueryConditionFlag)
                .collect(Collectors.toList());

        template.binding("conditionFields", conditionFields);
    }

    /**
     * 获取代码生成的模板
     *
     * @author fengshuonan
     * @Date 2018/12/13 9:46 AM
     */
    public abstract String getTemplateResourcePath();

    /**
     * 获取代码生成的目标路径（临时路径，用在打包下载）
     *
     * @author fengshuonan
     * @Date 2018/12/13 9:46 AM
     */
    public abstract String getGenerateFileTempPath();

    /**
     * 获取代码生成的目标路径（指定路径，用在下载到项目的目录直接）
     *
     * @author fengshuonan
     * @Date 2018/12/13 9:46 AM
     */
    public abstract String getGenerateFileDirectPath();
}
