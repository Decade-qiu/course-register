layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 大学信息表管理
     */
    var EduUniversity = {
        tableId: "eduUniversityTable"
    };

    /**
     * 初始化表格的列
     */
    EduUniversity.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'curriculumId', sort: true, title: '课程编号'},
            {field: 'curriculumName', sort: true, title: '课程名称'},
            {field: 'studentId', sort: true, title: '学生编号'},
            {field: 'studentName', sort: true, title: '学生名称'},
            {field: 'reTime', sort: true, title: '签到时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduUniversity.search = function () {
        var queryData = {};
        queryData['curriculumId'] = $("#curriculumId").val();
        table.reload(EduUniversity.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduUniversity.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduUniversity/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduUniversity.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduUniversity/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduUniversity.exportExcel = function () {
        var checkRows = table.checkStatus(EduUniversity.tableId);
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
    EduUniversity.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduUniversity/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduUniversity.tableId);
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
    lineNum = Math.max((parseInt(lineNum) * 5), 8);
    
    // 渲染表格
    var tableResult = table.render({
        elem: '#' + EduUniversity.tableId,
        url: Feng.ctxPath + '/eduUniversity/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduUniversity.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduUniversity.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduUniversity.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduUniversity.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduUniversity.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduUniversity.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduUniversity.onDeleteItem(data);
        }
    });
});
