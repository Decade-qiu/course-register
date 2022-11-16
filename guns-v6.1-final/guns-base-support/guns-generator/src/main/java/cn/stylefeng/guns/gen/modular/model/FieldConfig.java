package cn.stylefeng.guns.gen.modular.model;

import cn.stylefeng.guns.base.db.model.TableFieldInfo;
import cn.stylefeng.guns.gen.core.enums.InputTypeEnum;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 字段详情配置
 *
 * @author fengshuonan
 * @date 2020-01-19-5:19 下午
 */
@Data
public class FieldConfig extends TableFieldInfo {

    /**
     * 字段是否为查询条件
     */
    private Boolean queryConditionFlag = false;

    /**
     * 代码生成后，字段的input框样式，可参考
     */
    public Integer inputType = InputTypeEnum.TEXT.getType();

    /**
     * 代码生成后，字段的input框样式，可参考
     */
    public List<Map<String, Object>> inputTypeList = InputTypeEnum.getInputs();

    /**
     * 最终返回时候以inputType这个值为准
     *
     * @author fengshuonan
     * @Date 2020/1/19 6:18 下午
     */
    public List<Map<String, Object>> getInputTypeList() {
        return InputTypeEnum.getInputs(InputTypeEnum.valueOfType(this.inputType));
    }

    /**
     * 从TableField抽取属性
     *
     * @author fengshuonan
     * @Date 2020/1/27 1:22 下午
     */
    public static FieldConfig getFromTableField(TableField tableField) {
        FieldConfig fieldConfig = new FieldConfig();
        fieldConfig.setCamelFieldName(tableField.getPropertyName());
        fieldConfig.setColumnComment(tableField.getComment());
        fieldConfig.setColumnName(tableField.getName());
        return fieldConfig;

    }

}
