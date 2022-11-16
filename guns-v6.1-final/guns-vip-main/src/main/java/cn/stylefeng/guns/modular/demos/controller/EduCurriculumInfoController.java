package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCurriculumInfo;
import cn.stylefeng.guns.modular.demos.model.params.EduCurriculumInfoParam;
import cn.stylefeng.guns.modular.demos.service.EduCurriculumInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 课程信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:46
 */
@Controller
@RequestMapping("/eduCurriculumInfo")
public class EduCurriculumInfoController extends BaseController {

    private String PREFIX = "/demos/eduCurriculumInfo";

    @Autowired
    private EduCurriculumInfoService eduCurriculumInfoService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduCurriculumInfo.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduCurriculumInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduCurriculumInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduCurriculumInfoParam eduCurriculumInfoParam) {
        this.eduCurriculumInfoService.add(eduCurriculumInfoParam);
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
    public ResponseData editItem(EduCurriculumInfoParam eduCurriculumInfoParam) {
        this.eduCurriculumInfoService.update(eduCurriculumInfoParam);
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
    public ResponseData delete(EduCurriculumInfoParam eduCurriculumInfoParam) {
        this.eduCurriculumInfoService.delete(eduCurriculumInfoParam);
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
    public ResponseData detail(EduCurriculumInfoParam eduCurriculumInfoParam) {
        EduCurriculumInfo detail = this.eduCurriculumInfoService.getById(eduCurriculumInfoParam.getUniqueKey());
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
    public LayuiPageInfo list(EduCurriculumInfoParam eduCurriculumInfoParam) {
        return this.eduCurriculumInfoService.findPageBySpec(eduCurriculumInfoParam);
    }

}


