package cn.stylefeng.guns.gen.core.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 模板中用到的工具类
 *
 * @author fengshuonan
 * @date 2018-12-13-9:07 AM
 */
public class TemplateUtil {

    /**
     * 把一个数转化为int
     *
     * @author fengshuonan
     * @Date 2017/11/15 下午11:10
     */
    public static Integer toInt(Object val) {
        if (val instanceof Double) {
            BigDecimal bigDecimal = new BigDecimal((Double) val);
            return bigDecimal.intValue();
        } else {
            return Integer.valueOf(val.toString());
        }

    }

    /**
     * 当前时间
     *
     * @author stylefeng
     * @Date 2017/5/7 21:56
     */
    public static String currentTime() {
        return DateUtil.formatDateTime(new Date());
    }

    /**
     * 第一个首字母小写
     *
     * @author fengshuonan
     * @Date 2019/1/3 8:35 PM
     */
    public static String lowerFirst(String value) {
        return StrUtil.lowerFirst(value);
    }

    /**
     * 清理空白字符
     *
     * @author fengshuonan
     * @Date 2019/1/3 9:14 PM
     */
    public static String cleanWhite(String value) {
        return StrUtil.cleanBlank(value);
    }

}
