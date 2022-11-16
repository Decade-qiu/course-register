package cn.stylefeng.guns.gen.core.util;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.List;

/**
 * 表信息生成工具
 *
 * @author fengshuonan
 * @date 2019-01-10-10:54 AM
 */
public class TableInfoUtil {

    /**
     * 获取字段拼接在mapping.xml中的最终内容
     *
     * @author fengshuonan
     * @Date 2019/1/10 10:54 AM
     */
    public static String getFieldNames(TableInfo tableInfo) {

        String fieldNames;
        List<TableField> fields = tableInfo.getFields();

        StringBuilder names = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            TableField fd = fields.get(i);
            if (i == fields.size() - 1) {
                names.append(cov2col(fd));
            } else {
                names.append(cov2col(fd)).append(", ");
            }
        }
        fieldNames = names.toString();

        return fieldNames;
    }

    /**
     * mapper xml中的字字段添加as
     *
     * @param field 字段实体
     * @return 转换后的信息
     */
    private static String cov2col(TableField field) {

        if (null != field) {
            return field.isConvert() ? field.getName() + " AS \"" + field.getPropertyName() + "\"" : field.getName();
        }

        return StringUtils.EMPTY;
    }

}
