layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 院系信息表管理
     */
    var EduSchoolOfUniversity = {
        tableId: "eduSchoolOfUniversityTable"
    };

    /**
     * 初始化表格的列
     */
    EduSchoolOfUniversity.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'universityId', sort: true, title: '大学编号'},
            {field: 'universityName', sort: true, title: ''},
            {field: 'schoolName', sort: true, title: ''},
            {field: 'schoolShortName', sort: true, title: ''},
            {field: 'schoolId', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduSchoolOfUniversity.search = function () {
        var queryData = {};


        table.reload(EduSchoolOfUniversity.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduSchoolOfUniversity.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduSchoolOfUniversity/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduSchoolOfUniversity.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduSchoolOfUniversity/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduSchoolOfUniversity.exportExcel = function () {
        var checkRows = table.checkStatus(EduSchoolOfUniversity.tableId);
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
    EduSchoolOfUniversity.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduSchoolOfUniversity/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduSchoolOfUniversity.tableId);
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
        elem: '#' + EduSchoolOfUniversity.tableId,
        url: Feng.ctxPath + '/eduSchoolOfUniversity/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduSchoolOfUniversity.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduSchoolOfUniversity.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduSchoolOfUniversity.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduSchoolOfUniversity.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduSchoolOfUniversity.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduSchoolOfUniversity.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduSchoolOfUniversity.onDeleteItem(data);
        }
    });
});
