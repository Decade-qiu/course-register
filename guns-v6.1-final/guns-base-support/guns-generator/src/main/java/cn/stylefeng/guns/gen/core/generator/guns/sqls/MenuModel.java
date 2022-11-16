package cn.stylefeng.guns.gen.core.generator.guns.sqls;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * 菜单的实体
 *
 * @author fengshuonan
 * @date 2019-01-19-4:18 PM
 */
@Data
public class MenuModel {

    /**
     * 主键id
     */
    private Long menuId;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单父编号
     */
    private String pcode;

    /**
     * 当前菜单的所有父菜单编号
     */
    private String pcodes;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * url地址
     */
    private String url = "";

    /**
     * 菜单排序号
     */
    private Integer sort;

    /**
     * 菜单层级
     */
    private Integer levels;

    /**
     * 是否是菜单(字典)
     */
    private String menuFlag;

    /**
     * 备注
     */
    private String description = "";

    /**
     * 菜单状态(字典)
     */
    private String status = "ENABLE";

    /**
     * 是否打开新页面的标识(字典)
     */
    private String newPageFlag = "";

    /**
     * 是否打开(字典)
     */
    private String openFlag = "";

    /**
     * 系统分类（字典）
     */
    private String systemType = "";

    /**
     * 创建时间（默认当前时间）
     */
    private String createTime = DateUtil.formatDateTime(new Date());

    /**
     * 修改时间
     */
    private String updateTime = DateUtil.formatDateTime(new Date());

    /**
     * 创建人(默认管理员)
     */
    private Long createUser = 1L;

    /**
     * 修改人
     */
    private Long updateUser = 1L;

}
