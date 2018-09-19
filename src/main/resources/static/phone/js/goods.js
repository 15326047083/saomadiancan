function getGoodsList() {
    var str1 = "<li class=\"clearfix\">";
    var str3 = "<div class=\"menu-txt\">";
    var str7 = "<p class=\"list2\">";
    var str8 = "<div class=\"btn\">";
    $.ajax({
        type: "get",
        dataType: "json",
        url: "/goods/queryAll",
        success(data) {
            var types;
            $.ajax({
                type: "post",
                async: false,
                url: "/type/toList",
                dataType: "json",
                success(typeList) {
                    for (var i = 0; i < typeList.length; i++) {
                        if (i == 0)
                            $("#leftMenu ul").append("<li onclick='qiehuan(this)' class=\"active\">" + typeList[0].name + "<span class=\"num-price\"></span></li>");
                        else
                            $("#leftMenu ul").append("<li onclick='qiehuan(this)'>" + typeList[i].name + "</li>");
                    }
                    types = typeList;
                }
            });
            var allPrice = 0;
            for (var j = 0; j < types.length; j++) {
                if (j == 0)
                    $("#goods").append("<div id='type" + types[j].id + "' class=\"right-con con-active\"><ul></ul></div>");
                else
                    $("#goods").append("<div id='type" + types[j].id + "' class=\"right-con\"><ul></ul></div>");
                for (var i = 0; i < data.length; i++) {
                    if (data[i].typeId != types[j].id)
                        continue;
                    var cartNum;
                    $.ajax({
                        type: "get",
                        async: false,
                        url: "/cart/getNumByGoodsId/" + data[i].id,
                        success(data) {
                            cartNum = data;
                        }
                    });
                    var img = "/empJump/imgShow/" +
                        data[i].id ;
                    var str2 = "<div class=\"menu-img\"><img src=\"" + img + "\" width=\"55\" height=\"55\"/></div>";
                    var goodsName = data[i].name;
                    var str4 = "<h4>" + goodsName + "</h4>";
                    var price = data[i].discount / 100;
                    var str5 = "<h2>¥" + price + "</h2>";
                    var num = data[i].num;
                    var str6 = "<p class=\"list1\">原价 <em>¥" + data[i].price / 100 + "</em>，月售<em>" + num + "</em>份</p>";
                    var reallyPrice = data[i].discount / 100;

                    var display = "";
                    if (cartNum > 0) {
                        display = "style='display:inline-block'";
                    }
                    var str12 = "<i class=\"price\">" + reallyPrice + "</i></div></p></div></li>";
                    var str9 = "<button " + display + " class=\"minus\" onclick='minus(this," + data[i].id + ")'><strong>-</strong></button>";
                    var str10 = "<i " + display + ">" + cartNum * 1 + "</i>";
                    var str11 = "<button class=\"add\" onclick='add(this," + data[i].id + ")'><strong>+</strong></button>";
                    $("#type" + types[j].id + " ul").append(str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10 + str11 + str12);
                    $("#totalcountshow").html($("#totalcountshow").html() * 1 + cartNum);
                    allPrice = allPrice + data[i].discount * cartNum;
                }
            }

            $("#totalpriceshow").html((allPrice / 100).toFixed(2))
        }
    });

}

//选项卡
$(".con>div").hide();
$(".con>div:eq(0)").show();

function qiehuan(li) {
    $(li).addClass("active").siblings().removeClass("active");
    var n = $(".left-menu li").index(li);
    $(".left-menu li").index(li);
    $(".con>div").hide();
    $(".con>div:eq(" + n + ")").show();
}
