layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 教师信息表管理
     */
    var EduTeacherInfo = {
        tableId: "eduTeacherInfoTable"
    };

    /**
     * 初始化表格的列
     */
    EduTeacherInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'schoolId', sort: true, title: '学院'},
            {field: 'universityId', sort: true, title: '大学'},
            {field: 'teacherId', sort: true, title: '教师编号'},
            {field: 'teacherName', sort: true, title: '教师姓名'},
            {field: 'curriculums', sort: true, title: '教授课程'},
            {field: 'openId', sort: true, title: ''},
            {field: 'unionId', sort: true, title: ''},
            {field: 'teacherEmail', sort: true, title: '教师邮箱'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduTeacherInfo.search = function () {
        var queryData = {};


        table.reload(EduTeacherInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduTeacherInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduTeacherInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduTeacherInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduTeacherInfo/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduTeacherInfo.exportExcel = function () {
        var checkRows = table.checkStatus(EduTeacherInfo.tableId);
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
    EduTeacherInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduTeacherInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduTeacherInfo.tableId);
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
        elem: '#' + EduTeacherInfo.tableId,
        url: Feng.ctxPath + '/eduTeacherInfo/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduTeacherInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduTeacherInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduTeacherInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduTeacherInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduTeacherInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduTeacherInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduTeacherInfo.onDeleteItem(data);
        }
    });
});
