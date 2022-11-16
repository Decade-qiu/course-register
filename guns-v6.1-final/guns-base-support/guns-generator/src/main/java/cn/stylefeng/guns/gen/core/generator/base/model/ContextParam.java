package cn.stylefeng.guns.gen.core.generator.base.model;

import lombok.Data;

import java.util.Map;

import cn.stylefeng.guns.gen.core.enums.GenDownloadEnum;

/**
 * 代码生成所需要的上下文参数
 *
 * @author fengshuonan
 * @date 2018-12-12-4:30 PM
 */
@Data
public class ContextParam {

    /**
     * jdbc连接的驱动名称
     */
    private String jdbcDriver;

    /**
     * 数据库连接的url
     */
    private String jdbcUrl;

    /**
     * 数据库用户名
     */
    private String jdbcUserName;

    /**
     * 数据库连接的密码
     */
    private String jdbcPassword;

    /**
     * 代码生成路径
     */
    private String outputPath = "temp";

    /**
     * 项目的包路径
     */
    private String proPackage;

    /**
     * 代码生成作者
     */
    private String author = "fengshuonan";

    /**
     * 模块名称
     */
    private String modularName;

    /**
     * 是否开启swagger注解
     */
    private Boolean swagger = false;

    /**
     * 是否生成远程接口
     */
    private Boolean remote = true;

    /**
     * 修改和编辑页面是否弹框展示（key为tableName）
     */
    private Map<String, Boolean> jumpTypeMap;

    /**
     * 代码生成的路径
     */
    private GenDownloadEnum genDownloadEnum;

}
