package cn.stylefeng.guns.gen.core.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 不进行代码生成的字段
 *
 * @author fengshuonan
 * @Date 2020/1/24 11:57 上午
 */
public enum FilterFieldsEnum {

    create_time,
    create_user,
    update_time,
    update_user;

    /**
     * 获取被过滤的字段列表
     *
     * @author fengshuonan
     * @Date 2020/1/24 12:00 下午
     */
    public static List<String> getFields() {
        ArrayList<String> fields = new ArrayList<>();
        for (FilterFieldsEnum value : FilterFieldsEnum.values()) {
            fields.add(value.name());
        }
        return fields;
    }
}