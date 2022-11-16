package cn.stylefeng.guns.gen.modular.model.params;

import lombok.Data;

/**
 * 执行生成的参数接受类
 *
 * @author stylefeng
 * @date 2020/1/14
 */
@Data
public class ExecuteParam {

    private String author;
    private String proPackage;
    private String removePrefix;
    private Long dataSourceId;
    private String tables;
    private String modularName;
    private String version;
    private String swagger;
    private String remote;
    private String jumpTypeStr;
    private String genLocation;

}
