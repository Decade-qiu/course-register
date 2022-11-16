layui.use(['layer', 'ax', 'form', 'laydate', 'element', 'table'], function () {
    var $ = layui.$;
    var $ax = layui.ax;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;
    var element = layui.element;
    var table = layui.table;
    var fieldConfigList = [];

    table.render({
        elem: '#fieldTable',
        url: Feng.ctxPath + '/getTableFieldConfigs?tableName=' + $("#tableName").val() + "&dbId=" + $("#dbId").val(),
        parseData: function (res) {
            //获取返回的数据缓存起来
            fieldConfigList = res.data;
            return res;
        },
        page: false,
        cellMinWidth: 100,
        cols: [[
            {field: 'columnName', title: '字段名'},
            {field: 'columnComment', title: '字段注释'},
            {field: 'queryConditionFlag', title: '是否为查询条件', templet: '#conditionTpl'},
            {field: 'inputType', title: '字段属性样式', templet: '#inputTypeTpl'}
        ]]
    });
    form.render('select');

    //监听下拉选项操作
    form.on('select(columnStyleFilter)', function (data) {
        var columnName = data.elem.id;
        var inputType = data.elem.value;

        for (let i = 0, len = fieldConfigList.length; i < len; i++) {
            if (fieldConfigList[i].columnName === columnName) {
                fieldConfigList[i].inputType = inputType;
            }
        }

        console.log(fieldConfigList);
    });

    //监听单选事件
    form.on('checkbox(queryConditionFlagFilter)', function (data) {
        var columnName = data.elem.id;
        var checked = data.elem.checked;

        //fieldConfigList配置过字段则直接设置为checked
        for (let i = 0, len = fieldConfigList.length; i < len; i++) {
            if (fieldConfigList[i].columnName === columnName) {
                fieldConfigList[i].queryConditionFlag = checked;
            }
        }

        console.log(fieldConfigList);
    });

    //点击提交时
    $('#submit').click(function () {
        var requestBody = new Map();
        requestBody.set("tableName", $("#tableName").val());
        requestBody.set("fieldConfigList", fieldConfigList);

        layui.jquery.ajax({
            url: Feng.ctxPath + "/saveFieldsConfig",
            type: 'post',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: _mapToJson(requestBody),
            success: function (data) {
                fieldConfigList = [];
                Feng.success("保存成功");
                parent.layer.close(parent.layer.getFrameIndex(window.name));
            },
            error: function (data) {
                Feng.error("保存失败");
            }
        });

    });

    function _strMapToObj(strMap) {
        let obj = Object.create(null);
        for (let [k, v] of strMap) {
            obj[k] = v;
        }
        return obj;
    }

    function _mapToJson(map) {
        return JSON.stringify(_strMapToObj(map));
    }

});
