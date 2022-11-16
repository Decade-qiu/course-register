layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 选课信息表管理
     */
    var EduCourseSelectionInfo = {
        tableId: "eduCourseSelectionInfoTable"
    };

    /**
     * 初始化表格的列
     */
    EduCourseSelectionInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'uniqueKey', hide: true, title: ''},
            {field: 'universityId', sort: true, title: '大学'},
            {field: 'schoolId', sort: true, title: '学院'},
            {field: 'semesterId', sort: true, title: '学期'},
            {field: 'curriculumId', sort: true, title: '课程编号'},
            {align: 'center', field: 'curriculumLink', sort: true, title: '课程名称'},
            {align: 'center', field: 'curriculumIcon', title: '码', width: 60},
            {field: 'studentId', sort: true, title: '学号'},
            {field: 'studentName', sort: true, title: '学生姓名'},
            {field: 'teacherId', sort: true, title: '教师编号'},
            {field: 'teacherName', sort: true, title: '教师姓名'},
            {field: 'creditHour', sort: true, title: '学分'},
            {field: 'curriculumType', sort: true, title: '课程分类'},
            {field: 'timeForClass', sort: true, title: '上课时间'},
            {field: 'classroom', sort: true, title: '教室'},
            {field: 'grade', sort: true, title: '年级'},
            {field: 'classAndGrade', sort: true, title: '班级'},
            {field: 'majors', sort: true, title: '主修专业'},
            {field: 'schoolName', sort: true, title: '学院名'},
            {field: 'importTime', sort: true, title: '导入时间'},
            {field: 'status', sort: true, title: '有效状态'},
            {field: 'memo', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EduCourseSelectionInfo.search = function () {
        var queryData = {};
        queryData['studentId'] = $("#studentId").val();
        table.reload(EduCourseSelectionInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    EduCourseSelectionInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/eduCourseSelectionInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    EduCourseSelectionInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/eduCourseSelectionInfo/edit?uniqueKey=' + data.uniqueKey
    };

    /**
     * 导出excel按钮
     */
    EduCourseSelectionInfo.exportExcel = function () {
        var checkRows = table.checkStatus(EduCourseSelectionInfo.tableId);
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
    EduCourseSelectionInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eduCourseSelectionInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EduCourseSelectionInfo.tableId);
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
        elem: '#' + EduCourseSelectionInfo.tableId,
        url: Feng.ctxPath + '/eduCourseSelectionInfo/list',
        page: true,
        limit: lineNum,
        limits: [10,15,20,25,30,50,100],
        defaultToolbar:['filter', 'print'],
        toolbar: true,
        even: true,        
        height: "full-98",
        cellMinWidth: 100,
        cols: EduCourseSelectionInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EduCourseSelectionInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    EduCourseSelectionInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EduCourseSelectionInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EduCourseSelectionInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EduCourseSelectionInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            EduCourseSelectionInfo.onDeleteItem(data);
        }
    });
});
