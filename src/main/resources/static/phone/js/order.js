// 动态获取订单信息，生成展示页面
function getOrder() {
    $.ajax({
        type: "get",
        url: "/orders/toListOrdersByOrderNum",
        success(order) {
            if (order != "") {
                var str1 = "<tr><td align=\"left\" class=\"padl3\" style=\"color:#999\">订单号</td><td align=\"right\" width=\"50%\" style=\"color:#999\">";
                var str2 = "</td></tr><tr><td align=\"left\" class=\"padl3\">餐桌号</td><td align=\"right\" width=\"50%\">";
                var str3 = "</td></tr><tr style=\"border-bottom: solid 8px #f1f1f1;\"><td align=\"left\" class=\"padl3\">用餐人数</td><td align=\"right\" width=\"50%\">";
                $("#orders tbody").append(str1 + order.orderNum + str2 + order.deskNum + "号桌" + str3 + order.peopleNum + "</td></tr>");
                var str4 = "<tr><td align=\"left\" colspan=\"1\" class=\"padl3\">餐品总额</td><td align=\"right\" class=\"padr3\">￥<em>";
                var str5 = "</em></td></tr><tr><td align=\"left\" class=\"padl3\">订单</td><td align=\"right\" class=\"padr3 color-ec7602\" style=\"font-size: 16px;\"><a href=\"#\" class=\"padding-right23 colore2bf1e\">";
                var str6 = "<i href=\"#\" class=\"isNext\"></i></a></td></tr><tr style=\"border-top: solid 8px #f1f1f1;\"><td align=\"left\" colspan=\"1\" class=\"padl3\">实付金额:</td><td align=\"right\" class=\"padr3\"><a href=\"#\" class=\"padding-right23 colorf00\">";
                var str7 = "<i href=\"#\" class=\"isNext\"></i></a></td></tr>";

                var integralMoney;

                $.ajax({
                    url: "/login/getUser",
                    type: "get",
                    async: false,
                    dataType: "json",
                    error() {
                        integralMoney = 0;
                    },
                    success(user) {
                        integralMoney = user.integral / 100;
                    }
                });
                alert(integralMoney);
                $("#orderAllPrice tbody").append(str4 + order.allPrice / 100 + str5 + "积分抵￥" + integralMoney + str6 + "¥" + (order.allPrice / 100 - integralMoney * 1) + str7);
                // 判断订单付款状态，如果未付款，则生成按钮为取消订单以及确认付款按钮
                if (order.state == 0) {
                    $("#discussOrPay").append("<div style=\"height:1rem;\"></div>\n" +
                        "    <div class=\"order-set-paybutton\" style=\"margin-bottom: 0px;\">\n" +
                        "        <div onclick='backCart()' class=\"paybutton-left fl\" style=\"width: 40%;text-align: center;\">取消</div>\n" +
                        "        <div class=\"paybutton-right fr\" style=\"width: 60%;text-align: center;\">\n" +
                        "            <a href=\"/empJump/toPay\">确认付款</a>\n" +
                        "        </div>\n" +
                        "        <div class=\"clearfix\"></div>\n" +
                        "    </div>\n" +
                        "\n" +
                        "    ");
                } else {
                    // 如果已付款，则展示订单详情，并展示评价按钮，开启评价通道
                    $("#discussOrPay").append("\n" +
                        "    <div style=\"height:1rem;\"></div>\n" +
                        "    <div class=\"order-set-paybutton\" style=\"margin-bottom: 50px;\">\n" +
                        "        <div class=\"paybutton-right fr\" style=\"width: 100%;text-align: center;\">\n" +
                        "            <a href=\"#\">评价</a>\n" +
                        "        </div>\n" +
                        "        <div class=\"clearfix\"></div>\n" +
                        "    </div>\n" +
                        "\n" +
                        "    <div id=\"datePlugin\"></div>\n" +
                        "\n" +
                        "    <nav>\n" +
                        "        <a href=\"/empJump/toGoodsList\" class=\"homeIcon addclasstruenav\"><img src=\"/phone/img/index1-1.png\"/>点餐</a>\n" +
                        "        <a href=\"/empJump/toOrder\" class=\"categoryIcon\"><img src=\"/phone/img/index2.png\"/>订单</a>\n" +
                        "        <a href=\"service.html\" class=\"cartIcon numberCount\"><img src=\"/phone/img/index3.png\"/>服务</a>\n" +
                        "        <a href=\"/empJump/toMy\" class=\"userIcon\"><img src=\"/phone/img/index4.png\"/>我的</a>\n" +
                        "    </nav>");
                }
            } else {
                $("#discussOrPay").append("\n" +
                    "    <div id=\"datePlugin\"></div>\n" +
                    "\n" +
                    "    <nav>\n" +
                    "        <a href=\"/empJump/toGoodsList\" class=\"homeIcon addclasstruenav\"><img src=\"/phone/img/index1-1.png\"/>点餐</a>\n" +
                    "        <a href=\"/empJump/toOrder\" class=\"categoryIcon\"><img src=\"/phone/img/index2.png\"/>订单</a>\n" +
                    "        <a href=\"service.html\" class=\"cartIcon numberCount\"><img src=\"/phone/img/index3.png\"/>服务</a>\n" +
                    "        <a href=\"/empJump/toMy\" class=\"userIcon\"><img src=\"/phone/img/index4.png\"/>我的</a>\n" +
                    "    </nav>");
            }
        }
    });
}

// 取消订单，返回到选择菜品页面
function backCart() {
    $.ajax({
        type: "get",
        url: "/orders/deleteByOrderNum",
        success(data) {
            if (data == "success") {
                window.location = "/empJump/toGoodsList";
            } else {

            }
        }
    });
}

// 获取订单中的菜品列表
function getOrderGoods() {
    $.ajax({
        type: "get",
        url: "/orders/toListPurchaseByOrderNum",
        success(goods) {
            for (var i = 0; i < goods.length; i++) {
                $("#purchases tbody").append("<tr><td align=\"left\" class=\"padl3\">" + goods[i].goods_name + "</td>" +
                    "<td align=\"left\" width=\"10%\"><s style='font-size: 12px'>¥" + goods[i].goods_price / 100 +
                    "</s>&nbsp;&nbsp;<em style='color: red'>¥" + goods[i].goods_discount / 100 + "</em></td>" +
                    "<td align=\"left\" width=\"20%\">×<em>" + goods[i].purchase_num + "</em></td></tr>");
            }
        }
    });
}