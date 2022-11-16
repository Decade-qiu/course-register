package cn.stylefeng.guns.gen.core.generator.guns.html;

import org.beetl.core.Template;

import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;

import java.io.File;
import java.util.Map;

/**
 * Guns编辑页面生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsPageEditGenerator extends AbstractCustomGenerator {

    public GunsPageEditGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        super.bindingInputsParams(template);
    }

    @Override
    public String getTemplateResourcePath() {
        return "/gunsTemplates/page_edit.html.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/html/" + lowerEntity + "/" + lowerEntity + "_edit.html");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/webapp/pages/" + lowerEntity + "/" + lowerEntity + "_edit.html");
        return file.getAbsolutePath();
    }

}
