package cn.stylefeng.guns.gen.core.generator.guns.js;

import org.beetl.core.Template;

import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;

import java.io.File;
import java.util.Map;

/**
 * Guns编辑页面js生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsPageEditJsGenerator extends AbstractCustomGenerator {

    public GunsPageEditJsGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        super.bindingInputsParams(template);
    }

    @Override
    public String getTemplateResourcePath() {
        return "/gunsTemplates/page_edit.js.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/js/" + lowerEntity + "/" + lowerEntity + "_edit.js");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        String lowerEntity = (String) this.tableContext.get("lowerEntity");
        File file = new File(contextParam.getOutputPath() + "/webapp/assets/" + lowerEntity + "/" + lowerEntity + "_edit.js");
        return file.getAbsolutePath();
    }
}
