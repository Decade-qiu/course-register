package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCourseSelectionInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduCourseSelectionInfoParam;
import cn.stylefeng.guns.modular.demos.service.EduCourseSelectionInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 选课信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:46
 */
@Controller
@RequestMapping("/eduCourseSelectionInfo")
public class EduCourseSelectionInfoController extends BaseController {

    private String PREFIX = "/demos/eduCourseSelectionInfo";

    @Autowired
    private EduCourseSelectionInfoService eduCourseSelectionInfoService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduCourseSelectionInfo.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduCourseSelectionInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduCourseSelectionInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduCourseSelectionInfoParam eduCourseSelectionInfoParam) {
        this.eduCourseSelectionInfoService.add(eduCourseSelectionInfoParam);
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
    public ResponseData editItem(EduCourseSelectionInfoParam eduCourseSelectionInfoParam) {
        this.eduCourseSelectionInfoService.update(eduCourseSelectionInfoParam);
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
    public ResponseData delete(EduCourseSelectionInfoParam eduCourseSelectionInfoParam) {
        this.eduCourseSelectionInfoService.delete(eduCourseSelectionInfoParam);
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
    public ResponseData detail(EduCourseSelectionInfoParam eduCourseSelectionInfoParam) {
        EduCourseSelectionInfo detail = this.eduCourseSelectionInfoService.getById(eduCourseSelectionInfoParam.getUniqueKey());
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
    public LayuiPageInfo list(EduCourseSelectionInfoParam eduCourseSelectionInfoParam) {
        return this.eduCourseSelectionInfoService.findPageBySpec(eduCourseSelectionInfoParam);
    }

}


