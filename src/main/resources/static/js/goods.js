var page = 1;
var allPage = 1;

//商品表格显示
function goodstable(p) {
    if (p >= 1 && p <= allPage) {
        page = p;
        $.ajax({
            type: "post",
            url: "/goods/toList?page=" + p,
            dataType: "json",
            error() {
            },
            success(data) {
                $("#main tr").remove();
                allPage = Math.ceil(data.total / data.size);
                document.getElementById("span").innerHTML = page + "/" + allPage;
                for (var i = 0; i < data.rows.length; i++) {
                    // var t1 = $("#table1 tbody");
                    var trtd = "<td><input type='checkbox' name='click' value='" + data.rows[i].goodsId + "' /></td><td>" + data.rows[i].goodsId + "</td><td>" + data.rows[i].typeName + "</td><td>" + data.rows[i].goodsName + "</td><td>" + data.rows[i].goodsPrice +
                        "</td><td>" + data.rows[i].goodsDiscount + "</td><td>" + data.rows[i].goodsStartTime + "</td><td>" + data.rows[i].goodsEndTime + "</td>";
                    var tdbutten = "<td><a href='/goodsJump/toGoodsUpdate/" + data.rows[i].goodsId +
                        "'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
                        "<a href='/goodsJump/toGoodsShow/" + data.rows[i].goodsId +
                        "'><button class='layui-btn layui-btn-primary layui-btn-small'>查看</button></a></td>";
                    $("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
                }
            }
        });
    }
}

/*
获取类型列表信息
 */
function getTypeToList() {
    $.ajax({
        type: "post",
        url: "/type/toList",
        dataType: "json",
        success(json) {
            for (var i = 0; i < json.length; i++) {
                $("#typeName").append("<option value='" + json[i].id + "'" + ">" + json[i].name + "</option>");
            }
            layui.form.render('select');
        }
    });
}

function check() {
//自定义验证规则
    form.verify({
        price: [/^([1-9]\d*|[0]{1,1})$/, "只能填写数字"],
        pass: [/(.+){6,12}$/, '密码必须6到12位']
    });
}

//类型表格显示
function showtable() {
    $.ajax({
        type: "post",
        url: "/type/toList",
        dataType: "json",
        error() {
        },
        success(data) {
            for (var i = 0; i < data.length; i++) {
                var t1 = $("#table1 tbody");
                var trtd = "<td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].num + "</td>";
                var tdbutten = "<td><a href='/zhengJump/toUpdate/" + data[i].id +
                    "'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
                    "<button class='layui-btn layui-btn-primary layui-btn-small'>删除</button></td>";
                $("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
            }
        }
    });
}

/*
获取修改前列表信息
 */
function getgoods() {
    var typeName;

    $.ajax({
        type: "get",
        url: "/goods/toUpdate/" + $("#goodsid").val(),
        dataType: "json",
        error() {
        },
        success(json) {
            $("#name").val(json.name);
            $("#price").val(json.price);
            //   $("#LAY_demo_editor").val(json.info);
            $("#discount").val(json.discount);
            $("#startTime").val(json.startTime);
            $("#endTime").val(json.endTime);
            $("#num").val(json.num);
            layedit = layui.layedit;
            //创建一个编辑器
            editIndex = layedit.build('LAY_demo_editor');
            layedit.setContent(editIndex, json.info);

        }
    });
    $.ajax({
        type: "post",
        url: "/type/toList",
        dataType: "json",
        error() {
        },
        success(json) {
            for (var i = 0; i < json.length; i++) {
                $("#typeName").append("<option value='" + json[i].id + "'" + ">" + json[i].name + "</option>");
            }
            layui.form.render('select');
        }
    });
}

/*查看*/
function getcheckgoods() {

    $.ajax({
        type: "get",
        url: "/goods/toUpdate/" + $("#goodsid").val(),
        dataType: "json",
        error() {
        },
        success(json) {
            $("#goodsid").val(json.id);
            $("#name").val(json.name);
            $("#price").val(json.price);
            $("#info").append(json.info);
            $("#discount").val(json.discount);
            $("#startTime").val(json.startTime);
            $("#endTime").val(json.endTime);
            $("#typeid").val(json.typeId);

        }
    });
}

/*
全选/全不选
 */
function clickAll() {
    var clickall = document.getElementById('clickall');
    var check = document.getElementsByName('click');
    for (i = 0; i < check.length; i++) {
        check[i].checked = clickall.checked;
    }
}

//批量删除
function deleteAll() {
    var num = 0;
    var arrayId;
    var start = 0;
    var array = new Array();
    $("input[name='click']").each(function () {
        var id = $(this).val();
        if ($(this).prop('checked')) { //判断是否选择
            num = num + 1;
            array.push(id);
        }
    });
    if (num == 0) {
        alert("请选择数据");
    } else if (num > 0) {
        console.log(array);
        //删除前判断
        if (confirm("真的要删除吗?")) {
            /*$("input[name='click']").each(function () { //判断是否被选
                if (start == 0) {
                    arrayId = $(this).val() + ',';
                } else {
                    arrayId += $(this).val() + ',';
                }
                start += 1;
            });*/
            //alert("点击了确认按钮");
            $.ajax({
                type: "post",
                url: "/goods/todelete",
                data: {
                    'ids': array
                },
                success: function (result) {
                    if (result == 'success') {
                        alert("删除成功！");
                        window.location.href = "/goodsJump/toGoodsList";
                    } else {
                        alert("删除失败！");
                    }
                }
            });

        } else {
            return false;
        }

    }
    return arrayId;
}
