package cn.stylefeng.guns.gen.core.generator.guns.sqls;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;
import cn.stylefeng.guns.gen.core.util.TemplateUtil;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.beetl.core.Template;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Guns菜单相关的sql生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsMenuSqlGenerator extends AbstractCustomGenerator {

    public GunsMenuSqlGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        TableInfo tableInfo = (TableInfo) tableContext.get("table");
        template.binding("menus", getMenus(tableInfo));
    }

    @Override
    public String getTemplateResourcePath() {
        return "/gunsTemplates/menu_sql.sql.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/sqls/" + lowerEntity + "_menus.sql");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        return  this.getGenerateFileTempPath();
    }

    private List<MenuModel> getMenus(TableInfo tableInfo) {
        ArrayList<MenuModel> menuModels = new ArrayList<>();

        MenuModel parentMenu = new MenuModel();
        parentMenu.setMenuId(IdWorker.getId());
        parentMenu.setCode(StrUtil.toUnderlineCase(tableInfo.getEntityName()).toUpperCase());
        parentMenu.setPcode("0");
        parentMenu.setPcodes("[0],");
        if (StrUtil.isBlank(TemplateUtil.cleanWhite(tableInfo.getComment()))) {
            parentMenu.setName("空表名");
        } else {
            parentMenu.setName(TemplateUtil.cleanWhite(tableInfo.getComment()));
        }
        parentMenu.setIcon("fa-star");
        parentMenu.setUrl("/" + TemplateUtil.lowerFirst((String) tableContext.get("entity")));
        parentMenu.setSort(999);
        parentMenu.setLevels(1);
        parentMenu.setMenuFlag("Y");
        parentMenu.setSystemType("BASE_SYSTEM");
        menuModels.add(parentMenu);

        MenuModel addMenu = new MenuModel();
        addMenu.setMenuId(IdWorker.getId());
        addMenu.setCode(StrUtil.toUnderlineCase(tableInfo.getEntityName()).toUpperCase() + "_ADD");
        addMenu.setPcode(parentMenu.getCode());
        addMenu.setPcodes("[0],[" + parentMenu.getCode() + "],");
        addMenu.setName(parentMenu.getName() + "添加");
        addMenu.setIcon("fa-star");
        addMenu.setSort(999);
        addMenu.setLevels(2);
        addMenu.setMenuFlag("N");
        addMenu.setSystemType("BASE_SYSTEM");
        menuModels.add(addMenu);

        MenuModel editMenu = new MenuModel();
        editMenu.setMenuId(IdWorker.getId());
        editMenu.setCode(StrUtil.toUnderlineCase(tableInfo.getEntityName()).toUpperCase() + "_EDIT");
        editMenu.setPcode(parentMenu.getCode());
        editMenu.setPcodes("[0],[" + parentMenu.getCode() + "],");
        editMenu.setName(parentMenu.getName() + "修改");
        editMenu.setIcon("fa-star");
        editMenu.setSort(999);
        editMenu.setLevels(2);
        editMenu.setMenuFlag("N");
        editMenu.setSystemType("BASE_SYSTEM");
        menuModels.add(editMenu);

        MenuModel deleteMenu = new MenuModel();
        deleteMenu.setMenuId(IdWorker.getId());
        deleteMenu.setCode(StrUtil.toUnderlineCase(tableInfo.getEntityName()).toUpperCase() + "_DELETE");
        deleteMenu.setPcode(parentMenu.getCode());
        deleteMenu.setPcodes("[0],[" + parentMenu.getCode() + "],");
        deleteMenu.setName(parentMenu.getName() + "删除");
        deleteMenu.setIcon("fa-star");
        deleteMenu.setSort(999);
        deleteMenu.setLevels(2);
        deleteMenu.setMenuFlag("N");
        deleteMenu.setSystemType("BASE_SYSTEM");
        menuModels.add(deleteMenu);

        return menuModels;

    }
}
