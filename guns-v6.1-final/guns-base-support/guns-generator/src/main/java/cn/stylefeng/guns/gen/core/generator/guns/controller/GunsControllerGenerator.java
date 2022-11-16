package cn.stylefeng.guns.gen.core.generator.guns.controller;

import org.beetl.core.Template;

import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;

import java.io.File;
import java.util.Map;

/**
 * 带restful接口控制器生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsControllerGenerator extends AbstractCustomGenerator {

    public GunsControllerGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        template.binding("controllerPackage", contextParam.getProPackage() + ".controller");
    }

    @Override
    public String getTemplateResourcePath() {
        return "/gunsTemplates/controller.java.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String proPackage = this.contextParam.getProPackage();
        String proPath = proPackage.replaceAll("\\.", "/");
        File file = new File(contextParam.getOutputPath() + "/" + proPath + "/controller/" + tableContext.get("entity") + "Controller.java");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        String proPackage = this.contextParam.getProPackage();
        String proPath = proPackage.replaceAll("\\.", "/");
        File file = new File(contextParam.getOutputPath() + "/java/" + proPath + "/controller/" + tableContext.get("entity") + "Controller.java");
        return file.getAbsolutePath();
    }
}
