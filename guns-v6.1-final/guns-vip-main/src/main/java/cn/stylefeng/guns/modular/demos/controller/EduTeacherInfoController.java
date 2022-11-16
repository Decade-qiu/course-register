package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduTeacherInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduTeacherInfoParam;
import cn.stylefeng.guns.modular.demos.service.EduTeacherInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 教师信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:47
 */
@Controller
@RequestMapping("/eduTeacherInfo")
public class EduTeacherInfoController extends BaseController {

    private String PREFIX = "/demos/eduTeacherInfo";

    @Autowired
    private EduTeacherInfoService eduTeacherInfoService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduTeacherInfo.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduTeacherInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduTeacherInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduTeacherInfoParam eduTeacherInfoParam) {
        this.eduTeacherInfoService.add(eduTeacherInfoParam);
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
    public ResponseData editItem(EduTeacherInfoParam eduTeacherInfoParam) {
        this.eduTeacherInfoService.update(eduTeacherInfoParam);
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
    public ResponseData delete(EduTeacherInfoParam eduTeacherInfoParam) {
        this.eduTeacherInfoService.delete(eduTeacherInfoParam);
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
    public ResponseData detail(EduTeacherInfoParam eduTeacherInfoParam) {
        EduTeacherInfo detail = this.eduTeacherInfoService.getById(eduTeacherInfoParam.getUniqueKey());
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
    public LayuiPageInfo list(EduTeacherInfoParam eduTeacherInfoParam) {
        return this.eduTeacherInfoService.findPageBySpec(eduTeacherInfoParam);
    }

}


