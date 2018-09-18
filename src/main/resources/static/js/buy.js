function importBuy() {
    $("#importfrom").attr("style", "display:block;");
}

var page = 1;
var allPage = 1;

function getBuyList(p) {
    if (p >= 1 && p <= allPage) {
        page = p;
        $.ajax({
            url: "/buy/toList?page=" + p,
            type: "get",
            dataType: "json",
            success(data) {
                $("#main tr").remove();
                allPage = Math.ceil(data.total / data.size);
                document.getElementById("span").innerHTML = page + "/" + allPage;
                for (var i = 0; i < data.rows.length; i++) {
                    var trtd = "<td>" + data.rows[i].id + "</td><td>" + data.rows[i].name + "</td><td>" + new Date(parseInt(data.rows[i].buyDate)).toLocaleString().replace(/:\d{1,2}$/, ' ') +
                        "</td><td>" + data.rows[i].price + "</td><td>" + data.rows[i].num + "</td><td>" + data.rows[i].price * data.rows[i].num +
                        "</td><td>" + data.rows[i].userId + "</td><td>" + data.rows[i].info + "</td>";
                    $("#table1 tbody").append("<tr>" + trtd + "</tr>");
                }
            }
        });
    }
}
/*
function submitNewUser() {
    if ($("#price").val() < 1 && $("#price").val() != '') {
        alert("物品单价要大于0的整数");
        $("#price").val('');
        return false;
    }
    if ($("#num").val() < 1 && $("#num").val() != '') {
        alert("数量要大于0的整数");
        $("#num").val('');
        return false;
    }

}*/

function getCaigouEmpList() {
    $.ajax({
        type: "get",
        url: "/emp/roleList",
        dataType: "json",
        success(json) {
            for (var i = 0; i < json.length; i++) {
                $("#roles").append("<option value='" + json[i].id + "'" + ">" + json[i].name + "</option>");
            }
            layui.form.render('select');
        }
    });
}
