package cn.stylefeng.guns.gen.modular.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * session中存字段详情配置（session的key为 TABLE_FIELD_STYLES ）
 *
 * @author fengshuonan
 * @date 2020-01-19-5:19 下午
 */
@Data
public class GenSessionFieldConfigs {

    /**
     * key为tableName表名称，某个数据源下的表名称
     * <p>
     * value为表下的所有配置信息
     */
    public Map<String, List<FieldConfig>> fieldConfigs = new HashMap<>();

    /**
     * 返回session中是否包含某个数据源下，某个表的字段配置信息
     *
     * @author fengshuonan
     * @Date 2020/1/19 6:09 下午
     */
    public boolean containConfigFlag(String tableName) {
        if (fieldConfigs.get(tableName) != null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 返回字段的配置信息
     *
     * @author fengshuonan
     * @Date 2020/1/19 6:09 下午
     */
    public List<FieldConfig> getFieldConfigs(String tableName) {
        if (fieldConfigs.get(tableName) != null) {
            return fieldConfigs.get(tableName);
        } else {
            return new ArrayList<>();
        }
    }
}
