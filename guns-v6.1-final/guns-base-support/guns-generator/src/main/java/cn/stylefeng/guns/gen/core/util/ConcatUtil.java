package cn.stylefeng.guns.gen.core.util;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串拼接工具类
 *
 * @author fengshuonan
 * @date 2019-05-06-18:46
 */
public class ConcatUtil {

    //默认拼接符号
    public static final String DEFAULT_CONTRACT_SYMBOL = "CAT";

    /**
     * 获取字符串数组
     *
     * @param concatString 形式如CATaaCATbbCATcc的字符串，其中CAT为拼接符号
     * @author fengshuonan
     * @Date 2019-05-06 18:52
     */
    public static String[] getArray(String concatString) {
        return getArray(concatString, DEFAULT_CONTRACT_SYMBOL);
    }

    /**
     * 获取字符串数组
     *
     * @param concatString 形式如CATaaCATbbCATcc的字符串，其中CAT为拼接符号
     * @param symbol       拼接符号
     * @author fengshuonan
     * @Date 2019-05-06 18:52
     */
    public static String[] getArray(String concatString, String symbol) {
        if (StrUtil.isEmpty(concatString)) {
            return new String[]{};
        } else {
            if (concatString.length() <= symbol.length()) {
                return new String[]{};
            } else {
                concatString = concatString.substring(symbol.length());
                return concatString.split(symbol);
            }
        }
    }

}
