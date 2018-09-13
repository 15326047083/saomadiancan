//类型表格显示
var page = 1;
var allPage = 1;
function showtable(p,state) {
    console.log(p+" "+state+" "+allPage);
    if (p >= 1 && p <= allPage) {
        page = p;
        console.log("状态："+state);
        $.ajax({
            type: "post",
            url: "/orders/toListOrders?page=" +p+"&state="+state,
            dataType: "json",
            error() {
            },
            success(json) {
                $("#main tr").remove();
                allPage = Math.ceil(json.total / json.size);
                if(allPage<=0)
                    allPage=1;
                document.getElementById("span").innerHTML = page + "/" + allPage;
                for (var i = 0; i < json.rows.length; i++) {
                    var t1 = $("#table1 tbody");
                    var stateName=ordering(json.rows[i].state);
                    var trtd = "<td>" + json.rows[i].id + "</td><td>" + json.rows[i].orderNum + "</td><td>" + new Date(parseInt(json.rows[i].generateTime)).toLocaleString().replace(/:\d{1,2}$/, ' ') + "</td><td>" + json.rows[i].deskNum + "</td><td>" + json.rows[i].peopleNum + "</td><td>" + stateName + "</td>";
                    var tdbutten = "<td><a href='/zhengJump/toFindPurchase/"+json.rows[i].orderNum+
                        "/"+json.rows[i].state+"'><button class='layui-btn layui-btn-primary layui-btn-small'>查看</button></a>" +
                        "<a><button class='layui-btn layui-btn-primary layui-btn-small'>打印</button></a></td>";
                    $("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
                }
            }
        });
    }

}


function toFindPurchase() {
    $.ajax({
        type: "post",
        url: "/orders/toListPurchase/"+$("#ordersNum").val(),
        dataType: "json",
        error() {
        },
        success(json) {
            var totalPrice=0;
            var youhui=0;
            $("#main tr").remove();
            for (var i = 0; i < json.length; i++) {
                var t1 = $("#table1 tbody");
                var xiaoji = json[i].purchase_num * json[i].goods_discount;
                totalPrice = totalPrice + xiaoji;
                youhui = youhui + Number(json[i].purchase_num) * Number(json[i].goods_price) - Number(json[i].purchase_num) * Number(json[i].goods_discount);
                var trtd = "<td>" + json[i].purchase_orderNum + "</td><td>" + json[i].goods_name + "</td><td>" + json[i].goods_price + "</td><td>" + json[i].goods_discount + "</td><td>" + json[i].purchase_num + "</td><td>" + xiaoji + "</td>";
                if ($("#state").val()<=0) {
                var tdbutten = "<td><a onclick='deletet(" + json[i].purchase_id +
                    "," + xiaoji + "," + json[i].purchase_orderNum + ")'><button class='layui-btn layui-btn-primary layui-btn-small'>退菜</button></a></td>";
            }
                $("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
            }
            document.getElementById("sum").innerHTML = totalPrice;
            document.getElementById("dis").innerHTML = youhui;
        }
    });
}function deletet(id,xiaoji,ordersNum) {
    if(confirm("真的要退菜吗?")) {
        alert("点击了确认按钮");
        $.ajax({
            type: "post",
            url: "/orders/toDeletePurchase?id="+id+"&xiaoji="+xiaoji+"&ordersNum="+ordersNum,
            success: function(result) {
                if(result == 'success') {
                    alert("删除成功！");
                    toFindPurchase();
                } else {
                    alert("删除失败！");
                }
            }
        });
    } else {
        return false;
    }

}

function tobuy() {
    var ordersNum=$("#ordersNum").val();
    $.ajax({
        type: "post",
        url: "/orders/toUpdateDown?ordersNum="+ordersNum,
        error() {},
        success(json) {

            if (json=='success'){
            alert("付款成功");
                window.location.href = "/zhengJump/ordersList";
            }
        }
    });
}