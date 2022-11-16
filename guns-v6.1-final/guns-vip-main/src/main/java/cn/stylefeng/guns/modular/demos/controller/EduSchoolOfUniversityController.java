package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.EduSchoolOfUniversity;
import cn.stylefeng.guns.modular.demos.model.params.EduSchoolOfUniversityParam;
import cn.stylefeng.guns.modular.demos.service.EduSchoolOfUniversityService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 院系信息表控制器
 *
 * @author Frey Wang
 * @Date 2022-11-09 10:33:46
 */
@Controller
@RequestMapping("/eduSchoolOfUniversity")
public class EduSchoolOfUniversityController extends BaseController {

    private String PREFIX = "/demos/eduSchoolOfUniversity";

    @Autowired
    private EduSchoolOfUniversityService eduSchoolOfUniversityService;

    /**
     * 跳转到主页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eduSchoolOfUniversity.html";
    }

    /**
     * 新增页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eduSchoolOfUniversity_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eduSchoolOfUniversity_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Frey Wang
     * @Date 2022-11-09
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EduSchoolOfUniversityParam eduSchoolOfUniversityParam) {
        this.eduSchoolOfUniversityService.add(eduSchoolOfUniversityParam);
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
    public ResponseData editItem(EduSchoolOfUniversityParam eduSchoolOfUniversityParam) {
        this.eduSchoolOfUniversityService.update(eduSchoolOfUniversityParam);
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
    public ResponseData delete(EduSchoolOfUniversityParam eduSchoolOfUniversityParam) {
        this.eduSchoolOfUniversityService.delete(eduSchoolOfUniversityParam);
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
    public ResponseData detail(EduSchoolOfUniversityParam eduSchoolOfUniversityParam) {
        EduSchoolOfUniversity detail = this.eduSchoolOfUniversityService.getById(eduSchoolOfUniversityParam.getUniqueKey());
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
    public LayuiPageInfo list(EduSchoolOfUniversityParam eduSchoolOfUniversityParam) {
        return this.eduSchoolOfUniversityService.findPageBySpec(eduSchoolOfUniversityParam);
    }

}


