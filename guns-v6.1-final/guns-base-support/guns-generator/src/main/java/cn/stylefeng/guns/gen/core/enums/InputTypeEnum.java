package cn.stylefeng.guns.gen.core.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 输入框样式
 *
 * @author fengshuonan
 * @date 2020-01-19-5:21 下午
 */
@Getter
@Slf4j
public enum InputTypeEnum {

    TEXT(1, "文本框"),

    RADIO(2, "下拉单选"),

    CHECKS(3, "下拉多选"),

    DATE(4, "日期选择"),

    IMG(5, "图片上传");

    private Integer type;

    private String comment;

    InputTypeEnum(Integer type, String comment) {
        this.type = type;
        this.comment = comment;
    }

    /**
     * 获取所有下拉框类型
     *
     * @author fengshuonan
     * @Date 2020/1/19 5:28 下午
     */
    public static List<Map<String, Object>> getInputs() {
        List<Map<String, Object>> inputs = new LinkedList<>();
        for (InputTypeEnum item : InputTypeEnum.values()) {
            HashMap<String, Object> itemNameValue = new HashMap<>();
            itemNameValue.put("name", item.getComment());
            itemNameValue.put("value", item.getType());
            inputs.add(itemNameValue);
        }
        return inputs;
    }

    /**
     * 获取所有下拉框类型（讲传递的参数放在第一个位置）
     *
     * @author fengshuonan
     * @Date 2020/1/19 5:28 下午
     */
    public static List<Map<String, Object>> getInputs(InputTypeEnum inputTypeEnum) {
        List<Map<String, Object>> inputs = new LinkedList<>();
        for (InputTypeEnum item : InputTypeEnum.values()) {
            if (!inputTypeEnum.equals(item)) {
                HashMap<String, Object> itemNameValue = new HashMap<>();
                itemNameValue.put("name", item.getComment());
                itemNameValue.put("value", item.getType());
                inputs.add(itemNameValue);
            }
        }

        //最后再添加传递参数的
        HashMap<String, Object> itemNameValue = new HashMap<>();
        itemNameValue.put("name", inputTypeEnum.getComment());
        itemNameValue.put("value", inputTypeEnum.getType());
        inputs.add(0, itemNameValue);

        return inputs;
    }

    /**
     * 返回int对应的值
     *
     * @author fengshuonan
     * @Date 2020/1/19 6:21 下午
     */
    public static InputTypeEnum valueOfType(Integer type) {
        for (InputTypeEnum item : InputTypeEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        log.error("没有int={},对应的枚举！", type);
        return null;
    }

}
