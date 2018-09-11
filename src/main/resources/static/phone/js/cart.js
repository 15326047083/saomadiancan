// 获取购物车列表
function getCartList() {
    var str1 = "<li class=\"clearfix\">";
    var str3 = "<div class=\"menu-txt\">";
    var str7 = "<p class=\"list2\">";
    var str8 = "<div class=\"btn\">";
    $.ajax({
        type: "get",
        dataType: "json",
        url: "/cart/getCart",
        success(data) {
            var allPrice = 0;
            for (var i = 0; i < data.length; i++) {
                var cartNum = data[i].num;
                var img = "/phone/img/index (2).png";
                var str2 = "<div class=\"menu-img\"><img src=\"" + img + "\" width=\"55\" height=\"55\"/></div>";
                var goodsName = data[i].goodsName;
                var str4 = "<h4>" + goodsName + "</h4>";
                var price = data[i].goodsDiscount / 100;
                var str5 = "<h2>¥" + price + "</h2>";
                var num = data[i].goodsNum;
                var str6 = "<p class=\"list1\">原价 <em>¥" + data[i].goodsPrice / 100 + "</em>，月售<em>" + num + "</em>份</p>";
                var reallyPrice = data[i].goodsDiscount / 100;

                var display = "";
                if (cartNum > 0) {
                    display = "style='display:inline-block'";
                }
                var str12 = "<i class=\"price\">" + reallyPrice + "</i></div></p></div></li>";
                var str9 = "<button " + display + " class=\"minus\" onclick='cartMinus(this," + data[i].goodsId + ")'><strong>-</strong></button>";
                var str10 = "<i " + display + ">" + cartNum * 1 + "</i>";
                var str11 = "<button class=\"add\" onclick='add(this," + data[i].goodsId + ")'><strong>+</strong></button>";
                $("#cart ul").append(str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10 + str11 + str12);
                $("#totalcountshow").html($("#totalcountshow").html() * 1 + cartNum);
                allPrice = allPrice + data[i].goodsDiscount * cartNum;
            }
            $("#totalpriceshow").html((allPrice / 100).toFixed(2))
        }
    });

}

// 购物车减号
function cartMinus(minus, id) {
    minus.disabled = true;
    setTimeout(function () {
        minus.disabled = false;
    }, 700);
    var n = $(minus).next().text();
    var num = parseInt(n) - 1;

    $(minus).next().text(num);//减1

    var danjia = $(minus).nextAll(".price").text();//获取单价
    var a = $("#totalpriceshow").html();//获取当前所选总价
    $("#totalpriceshow").html((a * 1 - danjia * 1).toFixed(2));//计算当前所选总价

    var nm = $("#totalcountshow").html();//获取数量
    $("#totalcountshow").html(nm * 1 - 1);
    //如果数量小于或等于0则隐藏减号和数量
    deleteCart(id);
    if (num <= 0) {
        $(minus).parents('li').css("display", "none");
        $(minus).css("display", "none");
        jss();//改变按钮样式
        return
    }
}

// 提交订单
function submitOrder() {
    $.ajax({
        type: "get",
        url: "/orders/toSave",
        success(data) {
            if (data == "success") {
                window.location.href = "/empJump/toOrder";
            }
        }
    });
}