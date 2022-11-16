layui.use(['layer', 'ax', 'form', 'laydate', 'element', 'table', 'jquery'], function () {
    var $ = layui.$;
    var $ax = layui.ax;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;
    var element = layui.element;
    var table = layui.table;
    var jquery = layui.jquery;

    var Code = {
        tableNames: "",
        dbId: "",
        tables: {},
        jumpTypeBounceSet: new Set()
    };

    $('#code_gen').click(function () {
        window.location.href = Feng.ctxPath + "/gen";
    });

    $('#db_config').click(function () {
        window.location.href = Feng.ctxPath + "/db";
    });

    $('#add_db').click(function () {
        window.location.href = Feng.ctxPath + "/db/add";
    });

    table.render({
        elem: '#dbTableList'
        , url: Feng.ctxPath + '/databaseInfo/tableList'
        , page: false
        , cols: [[
            {type: 'checkbox'}
            , {field: 'tableName', title: '表的名称'}
            , {field: 'tableComment', title: '表的名称注释'}
            , {field: 'jumpType', title: '跳转是否弹窗', templet: '#switchTpl', unresize: true}
            , {toolbar: '#tableBar', title: '操作'}
        ]]
    });

    //监听跳转类型操作
    form.on('switch(jumpTypeFilter)', function (obj) {
        obj.elem.checked ? Code.jumpTypeBounceSet.add(obj.elem.value) : Code.jumpTypeBounceSet.delete(obj.elem.value);
        layer.tips(obj.elem.checked ? '新增修改页面弹框展示' : '新增修改页面页面跳转展示', obj.othis);
    });

    table.on('checkbox(dbTableList)', function (obj) {
        var checkStatus = table.checkStatus('dbTableList');
        var tableNames = "";
        for (var tableItem in checkStatus.data) {
            tableNames += "CAT" + checkStatus.data[tableItem].tableName;
        }
        Code.tableNames = tableNames;

        //选中行后，显示对应的操作按钮
        if (obj.type === "all") {
            if (obj.checked) {
                $("a[name='con-btn']").removeClass("layui-hide");
                $("a[name='param-box']").removeClass("layui-hide");
                $("div[name='jumpTypeDiv']").removeClass("layui-hide");
            } else {
                $("a[name='con-btn']").addClass("layui-hide");
                $("a[name='param-box']").addClass("layui-hide");
                $("div[name='jumpTypeDiv']").addClass("layui-hide");
            }
        } else {
            if (obj.checked) {
                $("#" + obj.data.tableName + "_opt").removeClass("layui-hide");
                $("#" + obj.data.tableName + "_pbt").removeClass("layui-hide");
                $("#" + obj.data.tableName + "_jt").removeClass("layui-hide");

            } else {
                $("#" + obj.data.tableName + "_opt").addClass("layui-hide");
                $("#" + obj.data.tableName + "_pbt").addClass("layui-hide");
                $("#" + obj.data.tableName + "_jt").addClass("layui-hide");
            }
        }
    });

    table.on('tool(dbTableList)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'conditionEdit') {
            top.layer.open({
                type: 2,
                title: '选择字段',
                area: ['900px', '600px'],
                content: Feng.ctxPath + '/tableFields?dbId=' + Code.dbId + "&tableName=" + data.tableName
            });
        }
    });

    form.on('select(dataSourceId)', function (data) {
        var dbId = data.value;
        Code.dbId = dbId;
        table.reload("dbTableList", {where: {dbId: dbId}});
    });


    $('#execute').on('click', function () {

        let author = $("#author").val();
        let proPackage = $("#proPackage").val();
        let removePrefix = $("#removePrefix").val();
        let dataSourceId = $("#dataSourceId").val();
        let modularName = $("#modularName").val();
        let version = $("input[name='version']:checked").val();
        let genLocation = $("input[name='genLocation']:checked").val();
        let swagger = $("input[name='swagger']:checked").val();
        let remote = $("input[name='remote']:checked").val();
        let set = Code.jumpTypeBounceSet;
        let jumpTypeStr = '';
        for (let s of set) {
            jumpTypeStr += 'CAT' + s;
        }

        var tempWindow = window.open('_blank');
        tempWindow.location = Feng.ctxPath + "/execute?dataSourceId=" + dataSourceId + "&author="
            + author + "&proPackage=" + proPackage + "&removePrefix=" + removePrefix + "&tables=" + Code.tableNames + "&modularName=" + modularName
            + "&version=" + version + "&swagger=" + swagger + "&remote=" + remote + '&jumpTypeStr=' + jumpTypeStr + '&genLocation=' + genLocation;
    });

    //初始化单体选择
    var activeSingleSelect = function () {
        $("#microDiv").hide();
    };

    //初始化微服务选择
    var activeMicroSelect = function () {
        $("#microDiv").show();
    };

    //监听如果选择微服务版本，则显示是否开启swagger
    form.on('radio(versionChecked)', function (data) {
        if (data.value === "single") {
            activeSingleSelect();
        } else {
            activeMicroSelect();
        }
    });

    //默认激活单体
    activeSingleSelect();

});
