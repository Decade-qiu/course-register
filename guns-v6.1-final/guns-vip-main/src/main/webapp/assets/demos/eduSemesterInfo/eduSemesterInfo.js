layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 学期信息表管理
     */
    var EduSemesterInfo = {
        tableId: "eduSemesterInfoTable"
    };

    /**
     * 初始化表格的列
     */
    EduSemesterInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'universityId', sort: true, title: ''},
            {field: 'schoolId', sort: true, title: ''},
            {field: 'semester', sort: true, title: ''},
            {field: 'startDate', sort: true, title: ''},
            {field: 'endDate', sort: true, title: ''},
            {field: 'weekNum', sort: true, title: ''},
            {field: 'memo', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduSemesterInfo.search = function () {
        var queryData = {};


        table.reload(EduSemesterInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduSemesterInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduSemesterInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduSemesterInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduSemesterInfo/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduSemesterInfo.exportExcel = function () {
        var checkRows = table.checkStatus(EduSemesterInfo.tableId);
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
    EduSemesterInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduSemesterInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduSemesterInfo.tableId);
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
        elem: '#' + EduSemesterInfo.tableId,
        url: Feng.ctxPath + '/eduSemesterInfo/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduSemesterInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduSemesterInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduSemesterInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduSemesterInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduSemesterInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduSemesterInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduSemesterInfo.onDeleteItem(data);
        }
    });
});
