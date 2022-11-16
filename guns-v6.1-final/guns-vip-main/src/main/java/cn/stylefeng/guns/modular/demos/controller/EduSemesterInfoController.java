package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSemesterInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduSemesterInfoParam;
import cn.stylefeng.guns.modular.demos.service.EduSemesterInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 学期信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:46
 */
@Controller
@RequestMapping("/eduSemesterInfo")
public class EduSemesterInfoController extends BaseController {

    private String PREFIX = "/demos/eduSemesterInfo";

    @Autowired
    private EduSemesterInfoService eduSemesterInfoService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduSemesterInfo.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduSemesterInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduSemesterInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduSemesterInfoParam eduSemesterInfoParam) {
        this.eduSemesterInfoService.add(eduSemesterInfoParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(EduSemesterInfoParam eduSemesterInfoParam) {
        this.eduSemesterInfoService.update(eduSemesterInfoParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(EduSemesterInfoParam eduSemesterInfoParam) {
        this.eduSemesterInfoService.delete(eduSemesterInfoParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(EduSemesterInfoParam eduSemesterInfoParam) {
        EduSemesterInfo detail = this.eduSemesterInfoService.getById(eduSemesterInfoParam.getUniqueKey());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(EduSemesterInfoParam eduSemesterInfoParam) {
        return this.eduSemesterInfoService.findPageBySpec(eduSemesterInfoParam);
    }

}


