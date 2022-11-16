package cn.stylefeng.guns.gen.core.generator.restful;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import cn.stylefeng.guns.gen.core.generator.base.model.ContextParam;
import cn.stylefeng.guns.gen.core.generator.restful.controller.RestfulControllerGenerator;
import cn.stylefeng.guns.gen.core.generator.restful.feign.FeignApiGenerator;
import cn.stylefeng.guns.gen.core.generator.restful.feign.FeignProviderGenerator;
import cn.stylefeng.guns.gen.core.generator.restful.mybatisplus.DefaultMpGenerator;
import cn.stylefeng.guns.gen.core.generator.restful.mybatisplus.param.MpParam;

import java.util.List;
import java.util.Map;

/**
 * 测试的执行器
 *
 * @author fengshuonan
 * @date 2018-12-18-6:39 PM
 */
public class RestfulApiExecutor {

    /**
     * 默认的生成器
     *
     * @author fengshuonan
     * @Date 2019/1/13 22:18
     */
    public static void executor(ContextParam contextParam, MpParam mpContext) {

        //执行mp的代码生成，生成entity,dao,service,model，生成后保留数据库元数据
        DefaultMpGenerator defaultMpGenerator = new DefaultMpGenerator(mpContext);
        defaultMpGenerator.initContext(contextParam);
        defaultMpGenerator.doGeneration();

        //获取元数据
        List<TableInfo> tableInfos = defaultMpGenerator.getTableInfos();
        Map<String, Map<String, Object>> everyTableContexts = defaultMpGenerator.getEveryTableContexts();

        //遍历所有表
        for (TableInfo tableInfo : tableInfos) {
            Map<String, Object> map = everyTableContexts.get(tableInfo.getName());

            //是否生成远程接口
            if (contextParam.getRemote()) {

                //生成api接口
                FeignApiGenerator feignApiGenerator = new FeignApiGenerator(map);
                feignApiGenerator.initContext(contextParam);
                feignApiGenerator.doGeneration();

                //生成provider
                FeignProviderGenerator feignProviderGenerator = new FeignProviderGenerator(map);
                feignProviderGenerator.initContext(contextParam);
                feignProviderGenerator.doGeneration();

            }


            //生成控制器
            RestfulControllerGenerator restfulControllerGenerator = new RestfulControllerGenerator(map);
            restfulControllerGenerator.initContext(contextParam);
            restfulControllerGenerator.doGeneration();
        }
    }

}
