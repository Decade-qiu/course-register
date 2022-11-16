package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduStudentInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduStudentInfoParam;
import cn.stylefeng.guns.modular.demos.service.EduStudentInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 学生信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:46
 */
@Controller
@RequestMapping("/eduStudentInfo")
public class EduStudentInfoController extends BaseController {

    private String PREFIX = "/demos/eduStudentInfo";

    @Autowired
    private EduStudentInfoService eduStudentInfoService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduStudentInfo.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduStudentInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduStudentInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduStudentInfoParam eduStudentInfoParam) {
        this.eduStudentInfoService.add(eduStudentInfoParam);
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
    public ResponseData editItem(EduStudentInfoParam eduStudentInfoParam) {
        this.eduStudentInfoService.update(eduStudentInfoParam);
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
    public ResponseData delete(EduStudentInfoParam eduStudentInfoParam) {
        this.eduStudentInfoService.delete(eduStudentInfoParam);
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
    public ResponseData detail(EduStudentInfoParam eduStudentInfoParam) {
        EduStudentInfo detail = this.eduStudentInfoService.getById(eduStudentInfoParam.getUniqueKey());
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
    public LayuiPageInfo list(EduStudentInfoParam eduStudentInfoParam) {
        return this.eduStudentInfoService.findPageBySpec(eduStudentInfoParam);
    }

}


