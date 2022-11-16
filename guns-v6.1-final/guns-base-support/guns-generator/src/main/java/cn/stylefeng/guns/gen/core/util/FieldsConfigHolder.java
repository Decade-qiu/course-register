package cn.stylefeng.guns.gen.core.util;

import cn.stylefeng.guns.gen.modular.model.GenSessionFieldConfigs;

/**
 * 临时变量存放
 *
 * @author fengshuonan
 * @date 2019-05-06-18:33
 */
public class FieldsConfigHolder {

    private static ThreadLocal<GenSessionFieldConfigs> threadLocal = new ThreadLocal<>();

    public static void put(GenSessionFieldConfigs value) {
        threadLocal.set(value);
    }

    public static GenSessionFieldConfigs get() {
        GenSessionFieldConfigs genSessionFieldConfigs = threadLocal.get();

        //threadlocal没有的话new一个
        if (genSessionFieldConfigs == null) {
            return new GenSessionFieldConfigs();
        } else {
            return genSessionFieldConfigs;
        }
    }

    public static void remove() {
        threadLocal.remove();
    }
}
