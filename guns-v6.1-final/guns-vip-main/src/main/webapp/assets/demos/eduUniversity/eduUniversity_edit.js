/**
 * 详情对话框
 */
var EduUniversityInfoDlg = {
    data: {
        uniqueKey: "",
        name: "",
        englishName: "",
        website: "",
        emailDomain: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;














    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/eduUniversity/detail?uniqueKey=" + Feng.getUrlParam("uniqueKey"));
    var result = ajax.start();
    form.val('eduUniversityForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/eduUniversity/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/eduUniversity'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/eduUniversity'
    });
});