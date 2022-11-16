package cn.stylefeng.guns.gen.core.generator.guns.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import cn.stylefeng.guns.gen.core.enums.GenDownloadEnum;
import cn.stylefeng.guns.gen.core.generator.base.AbstractMpGenerator;
import cn.stylefeng.guns.gen.core.generator.restful.mybatisplus.param.MpParam;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 默认的mybatis-plus生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class GunsMpGenerator extends AbstractMpGenerator {

    private MpParam mpContextParam;

    public GunsMpGenerator(MpParam mpContextParam) {
        this.mpContextParam = mpContextParam;
    }

    /**
     * 代码生成之前，配置代码生成器所需要的配置
     *
     * @author fengshuonan
     * @Date 2018/12/13 2:48 PM
     */
    @Override
    protected void beforeGeneration() {

        // 全局配置
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setEnableCache(false);
        globalConfig.setOpen(false);
        globalConfig.setAuthor(contextParam.getAuthor());
        globalConfig.setIdType(IdType.ID_WORKER);

        //打包下载，则生成到默认目录，直接下载到项目目录则路径上加个/java
        if (contextParam.getGenDownloadEnum().equals(GenDownloadEnum.DEFAULT_PATH)) {
            globalConfig.setOutputDir(contextParam.getOutputPath());
        } else {
            globalConfig.setOutputDir(contextParam.getOutputPath() + File.separator + "java");
        }

        //时间格式还用旧的Date
        globalConfig.setDateType(DateType.ONLY_DATE);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        if (mpContextParam.getGeneratorInterface()) {
            globalConfig.setServiceName("%sService");
            globalConfig.setServiceImplName("%sServiceImpl");
        } else {
            globalConfig.setServiceName("%sService");
            globalConfig.setServiceImplName("%sService");
        }

        // 数据源配置
        if (contextParam.getJdbcUrl().contains("oracle")) {
            dataSourceConfig.setDbType(DbType.ORACLE);
        } else if (contextParam.getJdbcUrl().contains("postgresql")) {
            dataSourceConfig.setDbType(DbType.POSTGRE_SQL);
        } else if (contextParam.getJdbcUrl().contains("sqlserver")) {
            dataSourceConfig.setDbType(DbType.SQL_SERVER);
        } else {
            dataSourceConfig.setDbType(DbType.MYSQL);
        }
        dataSourceConfig.setDriverName(contextParam.getJdbcDriver());
        dataSourceConfig.setUrl(contextParam.getJdbcUrl());
        dataSourceConfig.setUsername(contextParam.getJdbcUserName());
        dataSourceConfig.setPassword(contextParam.getJdbcPassword());

        // 策略配置
        // 大写命名
        strategyConfig.setCapitalMode(false);

        // 此处可以移除表前缀表前缀
        strategyConfig.setTablePrefix(this.mpContextParam.getRemoveTablePrefix());

        // 表名生成策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);

        // 需要生成的表
        strategyConfig.setInclude(this.mpContextParam.getIncludeTables());

        // 公共字段填充
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("CREATE_TIME", FieldFill.INSERT));
        tableFills.add(new TableFill("UPDATE_TIME", FieldFill.UPDATE));
        tableFills.add(new TableFill("CREATE_USER", FieldFill.INSERT));
        tableFills.add(new TableFill("UPDATE_USER", FieldFill.UPDATE));
        strategyConfig.setTableFillList(tableFills);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        templateConfig.setController(null);
        templateConfig.setXml("/mpTemplates/mapper.xml.vm");
        templateConfig.setMapper("/mpTemplates/mapper.java.vm");

        //如果不生成接口，就走不生成接口的模板
        if (!this.mpContextParam.getGeneratorInterface()) {
            templateConfig.setService(null);
            templateConfig.setServiceImpl("/mpTemplates/NoneInterfaceServiceImpl.java");
        } else {
            templateConfig.setService("/mpTemplates/service.java.vm");
            templateConfig.setServiceImpl("/mpTemplates/serviceImpl.java.vm");
        }

        // 包配置
        packageConfig.setParent(this.contextParam.getProPackage());
        packageConfig.setModuleName("");
        packageConfig.setXml("mapper.mapping");

        if (this.mpContextParam.getGeneratorInterface()) {
            packageConfig.setServiceImpl("service.impl");
            packageConfig.setService("service");
        } else {
            packageConfig.setServiceImpl("service");
            packageConfig.setService("service");
        }

        //自定义specification model的生成
        String SpecParamsTemplatePath = "/mpTemplates/specParam.java.vm";
        String SpecResultTemplatePath = "/mpTemplates/specResult.java.vm";
        List<FileOutConfig> focList = new ArrayList<>();

        String paramsParentPackage = this.contextParam.getProPackage().replaceAll("\\.", "/") + "/model/params";
        String resultParentPackage = this.contextParam.getProPackage().replaceAll("\\.", "/") + "/model/result";
        File paramsDir = new File(globalConfig.getOutputDir() + "/" + paramsParentPackage);
        File resultDir = new File(globalConfig.getOutputDir() + "/" + resultParentPackage);
        if (!paramsDir.exists()) {
            paramsDir.mkdirs();
        }
        if (!resultDir.exists()) {
            resultDir.mkdirs();
        }

        //model的查询条件
        focList.add(new FileOutConfig(SpecParamsTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return globalConfig.getOutputDir() + "/" + paramsParentPackage + "/" + tableInfo.getEntityName() + "Param.java";
            }
        });
        focList.add(new FileOutConfig(SpecResultTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return globalConfig.getOutputDir() + "/" + resultParentPackage + "/" + tableInfo.getEntityName() + "Result.java";
            }
        });
        injectionConfig.setFileOutConfigList(focList);

        //自定义specification里的参数
        HashMap<String, Object> contexMap = new HashMap<>();
        contexMap.put("EntitySpecParams", this.contextParam.getProPackage() + ".model.params");
        contexMap.put("EntitySpecResult", this.contextParam.getProPackage() + ".model.result");
        injectionConfig.setMap(contexMap);
    }

}
