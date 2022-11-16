layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 课程信息表管理
     */
    var EduCurriculumInfo = {
        tableId: "eduCurriculumInfoTable"
    };

    /**
     * 初始化表格的列
     */
    EduCurriculumInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'schoolId', sort: true, title: '学院编号'},
            {field: 'universityId', sort: true, title: '大学编号'},
            {field: 'curriculumId', sort: true, title: '课程编号'},
            {field: 'curriculumName', sort: true, title: '课程名'},
            {field: 'curriculumEnglishName', sort: true, title: ''},
            {field: 'teachers', sort: true, title: '上课老师'},
            {field: 'classrooms', sort: true, title: '上课地点'},
            {field: 'creditHour', sort: true, title: '学分'},
            {field: 'curriculumType', sort: true, title: '课程分类'},
            {field: 'timeForClass', sort: true, title: ''},
            {field: 'semesterId', sort: true, title: '学期'},
            {field: 'teacherId', sort: true, title: ''},
            {field: 'needSignin', sort: true, title: ''},
            {field: 'courseSelectNum', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduCurriculumInfo.search = function () {
        var queryData = {};


        table.reload(EduCurriculumInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduCurriculumInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduCurriculumInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduCurriculumInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduCurriculumInfo/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduCurriculumInfo.exportExcel = function () {
        var checkRows = table.checkStatus(EduCurriculumInfo.tableId);
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
    EduCurriculumInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduCurriculumInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduCurriculumInfo.tableId);
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
        elem: '#' + EduCurriculumInfo.tableId,
        url: Feng.ctxPath + '/eduCurriculumInfo/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduCurriculumInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduCurriculumInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduCurriculumInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduCurriculumInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduCurriculumInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduCurriculumInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduCurriculumInfo.onDeleteItem(data);
        }
    });
});
