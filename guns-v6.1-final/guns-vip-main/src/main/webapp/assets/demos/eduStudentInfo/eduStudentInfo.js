layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 学生信息表管理
     */
    var EduStudentInfo = {
        tableId: "eduStudentInfoTable"
    };

    /**
     * 初始化表格的列
     */
    EduStudentInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'schoolId', sort: true, title: ''},
            {field: 'universityId', sort: true, title: '大学编号'},
            {field: 'studentId', sort: true, title: '学号'},
            {field: 'studentName', sort: true, title: '姓名'},
            {field: 'grade', sort: true, title: '年级'},
            {field: 'classAndGrade', sort: true, title: '班级'},
            {field: 'majors', sort: true, title: '专业'},
            {field: 'classRepresentative', sort: true, title: ''},
            {field: 'markSigninLimits', sort: true, title: ''},
            {field: 'modifyTime', sort: true, title: ''},
            {field: 'avatarUrl', sort: true, title: ''},
            {field: 'studentEmail', sort: true, title: '学生邮箱'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduStudentInfo.search = function () {
        var queryData = {};


        table.reload(EduStudentInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduStudentInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduStudentInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduStudentInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduStudentInfo/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduStudentInfo.exportExcel = function () {
        var checkRows = table.checkStatus(EduStudentInfo.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    EduStudentInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduStudentInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduStudentInfo.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("uniqueKey", data.uniqueKey);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    var tableHeigth = $(document).height();
    var lineHeight = $(".layui-form-item").height();
    var tableLine = tableHeigth / (lineHeight + 4);
    var lineNum = parseInt(tableLine) / 5 ;
    lineNum = Math.max((parseInt(lineNum) * 5), 5);
    
    // 渲染表格
    var tableResult = table.render({
        elem: '#' + EduStudentInfo.tableId,
        url: Feng.ctxPath + '/eduStudentInfo/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduStudentInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduStudentInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduStudentInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduStudentInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduStudentInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduStudentInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduStudentInfo.onDeleteItem(data);
        }
    });
});
