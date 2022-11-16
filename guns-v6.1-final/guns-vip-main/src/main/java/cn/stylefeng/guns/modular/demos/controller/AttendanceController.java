package cn.stylefeng.guns.modular.demos.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.stylefeng.guns.modular.demos.entity.EduCourseSelectionInfo;
import cn.stylefeng.guns.modular.demos.entity.EduCurriculumInfo;
import cn.stylefeng.guns.modular.demos.entity.EduUniversity;
import cn.stylefeng.guns.modular.demos.model.params.EduCourseSelectionInfoParam;
import cn.stylefeng.guns.modular.demos.model.params.EduCurriculumInfoParam;
import cn.stylefeng.guns.modular.demos.model.params.EduUniversityParam;
import cn.stylefeng.guns.modular.demos.model.result.EduCourseSelectionInfoResult;
import cn.stylefeng.guns.modular.demos.model.result.EduCurriculumInfoResult;
import cn.stylefeng.guns.modular.demos.model.result.EduUniversityResult;
import cn.stylefeng.guns.modular.demos.service.EduCourseSelectionInfoService;
import cn.stylefeng.guns.modular.demos.service.EduCurriculumInfoService;
import cn.stylefeng.guns.modular.demos.service.EduUniversityService;
import cn.stylefeng.guns.modular.demos.service.impl.EduCourseSelectionInfoServiceImpl;
import cn.stylefeng.guns.modular.demos.service.impl.EduUniversityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.stylefeng.guns.modular.demos.model.params.EduStudentInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.EduStudentInfoResult;
import cn.stylefeng.guns.modular.demos.service.EduStudentInfoService;
import cn.stylefeng.guns.modular.wechat.WechatCorpMgr;
import cn.stylefeng.roses.core.base.controller.BaseController;

@Controller
public class AttendanceController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    private EduStudentInfoService eduStudentInfoService;

	@Autowired
	private EduUniversityService re;

	@Autowired
	private EduCurriculumInfoService course;
    
	// private int corpAgentId = 1000014;
	// private static String domain = "signin.biggeese.com";

	private int corpAgentId = 1000006;// A组
	// private int corpAgentId = 1000008;//B组
	// private int corpAgentId = 1000024;//组C
	private static String domain = "freya.picp.io:8080";

	private static final String CORP_ID = WechatCorpMgr.CORP_ID;

	@RequestMapping(value = "/qrcode", method = RequestMethod.GET)

	public String qrcode(Model model, HttpServletRequest request) {

		String sState = super.getPara("state");
		logger.info("state=" + sState);

		model.addAttribute("appid", CORP_ID);
		model.addAttribute("agentid", corpAgentId);
		model.addAttribute("redirect_uri", "http%3A%2F%2F" + domain + "/attendance");
		model.addAttribute("state", sState);
		model.addAttribute("refresh", (60 + Math.random() * 60));
		//String sty = "LmltcG93ZXJCb3ggLnFyY29kZSB7d2lkdGg6IDE4MHB4O30NCi5pbXBvd2VyQm94IC50aXRsZSB7ZGlzcGxheTogbm9uZTt9DQouaW1wb3dlckJveCAuaW5mbyB7d2lkdGg6IDIwMHB4O30NCi5zdGF0dXNfaWNvbiB7ZGlzcGxheTogbm9uZX0NCi5pbXBvd2VyQm94IC5zdGF0dXMge3RleHQtYWxpZ246IGNlbnRlcjt9=";
		String s2 = "LmltcG93ZXJCb3ggLnFyY29kZSB7d2lkdGg6IDE2MHB4O30KLmltcG93ZXJCb3ggLnRpdGxlIHtkaXNwbGF5OiBub25lO30KLmltcG93ZXJCb3ggLmluZm8ge3dpZHRoOiAyMDBweDt9Ci5zdGF0dXNfaWNvbiB7ZGlzcGxheTogbm9uZSAgIWltcG9ydGFudH0KLmltcG93ZXJCb3ggLnN0YXR1cyB7dGV4dC1hbGlnbjogY2VudGVyO30gCi5pbXBvd2VyQm94IHt3aWR0aDogODAlO30K";
		model.addAttribute("href",
				"data:text/css;base64,"+s2);
		return "/qrcode.html";

	}

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance(Model model, HttpServletRequest request) {

		String code = super.getPara("code").trim();
		String state = super.getPara("state").substring(11);// 可能是教师名工号，也可能是教室名字，或者是选课编号; curriculum:10285-scst-2021-2022-1-SOEN7858
		System.err.println("code"+code);
		System.err.println("state"+state);
		logger.info("##code=" + code + " state=" + state);

		String userAccount = WechatCorpMgr.getInstance().getUserIdByCode(code, corpAgentId);
		logger.info("##userAccount=" + userAccount);
		System.err.println(userAccount);
		//TODO, get User Name & avatar from local DB

		List<EduStudentInfoResult> list = eduStudentInfoService.findListBySpec(new EduStudentInfoParam());

		EduStudentInfoResult result = list.get((int)(Math.random()*list.size()));
		for (EduStudentInfoResult stu : list){
			if (stu.getStudentEmail().equals(userAccount)) result = stu;
		}
		List<EduCurriculumInfoResult> cou = course.findListBySpec(new EduCurriculumInfoParam());
		EduCurriculumInfoResult tpc = cou.get((int)(Math.random()*list.size()));
		for (EduCurriculumInfoResult cc : cou){
			if (cc.getUniqueKey().equals(state)){
				tpc = cc;
			}
		}
		System.err.println(tpc.getUniqueKey()+" "+tpc.getCurriculumName());
		re.add(new EduUniversityParam(state, tpc.getCurriculumId(), tpc.getCurriculumName(),
				result.getStudentId(), result.getStudentName(), new Date()));
		
		// TODO
		model.addAttribute("attendance", "/qrcode");
		model.addAttribute("name", result.getStudentName());
		model.addAttribute("avatar", result.getAvatarUrl());

		return "/attendance.html";
	}

}
