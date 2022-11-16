/**
 * 添加或者修改页面
 */
var EduCurriculumInfoInfoDlg = {
    data: {
        uniqueKey: "",
        schoolId: "",
        universityId: "",
        curriculumId: "",
        curriculumName: "",
        curriculumEnglishName: "",
        teachers: "",
        classrooms: "",
        creditHour: "",
        curriculumType: "",
        timeForClass: "",
        semesterId: "",
        teacherId: "",
        needSignin: "",
        courseSelectNum: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;












































    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/eduCurriculumInfo/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/eduCurriculumInfo'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/eduCurriculumInfo'
    });

});