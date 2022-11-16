package cn.stylefeng.guns.gen.core.generator.guns.html;

import org.beetl.core.Template;

import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;

import java.io.File;
import java.util.Map;

/**
 * Guns主页面生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsPageIndexGenerator extends AbstractCustomGenerator {

    public GunsPageIndexGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public String getTemplateResourcePath() {
        return "/gunsTemplates/page.html.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/html/" + lowerEntity + "/" + lowerEntity + ".html");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/webapp/pages/" + lowerEntity + "/" + lowerEntity + ".html");
        return file.getAbsolutePath();
    }

    /**
     * 绑定查询参数
     *
     * @author stylefeng
     * @date 2020/1/17
     */
    @Override
    public void bindingOthers(Template template) {
        super.bindingConditionParams(template);
    }
}
