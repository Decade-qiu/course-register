/**
 * 详情对话框
 */
var EduCourseSelectionInfoInfoDlg = {
    data: {
        uniqueKey: "",
        universityId: "",
        schoolId: "",
        semesterId: "",
        curriculumId: "",
        curriculumName: "",
        studentId: "",
        studentName: "",
        teacherId: "",
        teacherName: "",
        creditHour: "",
        curriculumType: "",
        timeForClass: "",
        classroom: "",
        grade: "",
        classAndGrade: "",
        majors: "",
        schoolName: "",
        importTime: "",
        status: "",
        memo: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;






























































    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/eduCourseSelectionInfo/detail?uniqueKey=" + Feng.getUrlParam("uniqueKey"));
    var result = ajax.start();
    form.val('eduCourseSelectionInfoForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/eduCourseSelectionInfo/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/eduCourseSelectionInfo'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/eduCourseSelectionInfo'
    });
});