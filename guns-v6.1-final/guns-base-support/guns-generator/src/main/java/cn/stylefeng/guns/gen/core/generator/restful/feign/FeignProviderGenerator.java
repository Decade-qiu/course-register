package cn.stylefeng.guns.gen.core.generator.restful.feign;

import org.beetl.core.Template;

import cn.stylefeng.guns.gen.core.generator.base.AbstractCustomGenerator;

import java.io.File;
import java.util.Map;

/**
 * feign的provider生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class FeignProviderGenerator extends AbstractCustomGenerator {

    public FeignProviderGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        template.binding("apiPackage", contextParam.getProPackage() + ".api");
        template.binding("providerPackage", contextParam.getProPackage() + ".provider");
    }

    @Override
    public String getTemplateResourcePath() {
        return "/feignTemplates/FeignProvider.btl";
    }

    @Override
    public String getGenerateFileTempPath() {
        String proPackage = this.contextParam.getProPackage();
        String proPath = proPackage.replaceAll("\\.", "/");
        File file = new File(contextParam.getOutputPath() + "/" + proPath + "/provider/" + tableContext.get("entity") + "Provider.java");
        return file.getAbsolutePath();
    }

    @Override
    public String getGenerateFileDirectPath() {
        return  this.getGenerateFileTempPath();
    }
}
