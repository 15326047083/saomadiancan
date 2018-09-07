//获取星星数量
function star(num) {
    var str = "";
    for (var i = 0; i < num; i++) {
        str = str + "<i style='color:orange' class='layui-icon'>&#xe658;</i>";
    }
    return str;
}

function reply(discussId) {
    $("div#reply").remove();
    $("#div" + discussId).append("<div id=\"reply\" class=\"layui-form-item layui-form-text\">" +
        "<div class=\"layui-input-block\"><form id=\"form\" action='/discuss/saveReply' method=\"post\" class=\"layui-form layui-form-pane\">" +
        "<input name='discussId' type='hidden' value='" + discussId + "'/>" +
        "<textarea class=\"layui-textarea layui-hide\" name=\"info\" lay-verify=\"content\"id=\"LAY_demo_editor\">" +
        "</textarea><button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"sub\">提交</button></form></div></div>");
    layedit = layui.layedit;
    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');
}

var page = 1;
var allPage = 1;

function getDiscussList(p) {
    var str1 = "<blockquote class=\"layui-elem-quote layui-quote-nm\"> <p style=\"color: grey;\"><i class=\"layui-icon\">&#xe612;</i>" +
        " 匿名用户：<br/></p><div style=\"margin-left: 30px;\"> <div id='div";
    var str17 = "'>环境评分：";
    // +星星
    var str2 = "<br/>服务评分：";
    // +星星
    var str3 = "<br/>菜品评分：";
    // +星星
    var str4 = "<br/>评价详情：";
    // +详情
    var str5 = "<br/><span style=\"margin-left: -30px;color: orange;\"><i class=\"layui-icon\">&#xe60e;</i>";
    // +时间
    var str6 = "</span>";
    var str14 = "<div id=\"aa\" style=\"float: right;\"><input onclick=\"reply(";
    // +评价ID
    var str7 = ")\" type=\"button\" class=\"layui-btn\" value=\"回复\"/></div>";
    var str16 = "</div></div>";
    var str12 = "<div><blockquote class=\"layui-elem-quote layui-quote-nm\">回复内容：";
    // +回复内容
    var str10 = "<br/><span style=\"color: orange\"><i class=\"layui-icon\">&#xe60e;</i>";
    // +时间
    var str11 = "</span></blockquote></div>";
    var str13 = "</blockquote>";
    if (p >= 1 && p <= allPage) {
        page = p;
        $.ajax({
            type: "get",
            url: "/discuss/DiscussList?page=" + p,
            dataType: "json",
            success(data) {
                $("#main blockquote").remove();
                allPage = Math.ceil(data.total / data.size);
                document.getElementById("span").innerHTML = page + "/" + allPage;
                for (var i = 0; i < data.rows.length; i++) {
                    var reply;
                    var button;
                    if (data.rows[i].replyId > 0) {
                        reply = str12 + data.rows[i].replyInfo + str10 + new Date(parseInt(data.rows[i].replyTime)).toLocaleString().replace(/:\d{1,2}$/, ' ') + str11;
                        button = "";
                    }
                    else {
                        reply = "";
                        button = str14 + data.rows[i].discussId + str7;
                    }
                    $("#main").append(str1 + data.rows[i].discussId + str17 + star(data.rows[i].discussEnLevel) + str2 + star(data.rows[i].discussServiceLevel)
                        + str3 + star(data.rows[i].discussQuLevel) + str4 + data.rows[i].discussInfo + str5 + new Date(parseInt(data.rows[i].discussTime)).toLocaleString().replace(/:\d{1,2}$/, ' ')
                        + str6 + button + str16 + reply + str13);
                }
            }
        });
    }
}