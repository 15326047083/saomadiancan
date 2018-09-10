function getCartList() {

}

function add(add, id) {
    add.disabled = true;
    setTimeout(function () {
        add.disabled = false;
    }, 700);
    $(add).prevAll().css("display", "inline-block");
    var n = $(add).prev().text();
    var num = parseInt(n) + 1;
    if (num == 0) {
        return;
    }
    $(add).prev().text(num);
    var danjia = $(add).next().text();//获取单价
    var a = $("#totalpriceshow").html();//获取当前所选总价
    $("#totalpriceshow").html((a * 1 + danjia * 1).toFixed(2));//计算当前所选总价

    var nm = $("#totalcountshow").html();//获取数量
    $("#totalcountshow").html(nm * 1 + 1);
    jss();//<span style='font-family: Arial, Helvetica, sans-serif;'></span>   改变按钮样式
    newCart(id);
}

function minus(minus, id) {
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
        $(minus).next().css("display", "none");
        $(minus).css("display", "none");
        jss();//改变按钮样式
        return
    }
}

function newCart(id) {
    $.ajax({
        type: "get",
        url: "/cart/addGoodsToCart/" + id
    });
}

function deleteCart(id) {
    $.ajax({
        type: "get",
        url: "/cart/deleteByGoodsId/" + id
    });
}

function jss() {
    var m = $("#totalcountshow").html();
    if (m > 0) {
        $(".right").find("a").removeClass("disable");
    } else {
        $(".right").find("a").addClass("disable");
    }
}

/*
$(function () {
    //加的效果
    $(".add").click(function () {
        alert(1111111);
        $(this).prevAll().css("display", "inline-block");
        var n = $(this).prev().text();
        alert(n);
        var num = parseInt(n) + 1;
        if (num == 0) {
            return;
        }
        $(this).prev().text(num);
        var danjia = $(this).next().text();//获取单价
        var a = $("#totalpriceshow").html();//获取当前所选总价
        $("#totalpriceshow").html((a * 1 + danjia * 1).toFixed(2));//计算当前所选总价

        var nm = $("#totalcountshow").html();//获取数量
        $("#totalcountshow").html(nm * 1 + 1);
        jss();//<span style='font-family: Arial, Helvetica, sans-serif;'></span>   改变按钮样式
    });
    //减的效果
    $(".minus").click(function () {
        var n = $(this).next().text();
        var num = parseInt(n) - 1;

        $(this).next().text(num);//减1

        var danjia = $(this).nextAll(".price").text();//获取单价
        var a = $("#totalpriceshow").html();//获取当前所选总价
        $("#totalpriceshow").html((a * 1 - danjia * 1).toFixed(2));//计算当前所选总价

        var nm = $("#totalcountshow").html();//获取数量
        $("#totalcountshow").html(nm * 1 - 1);
        //如果数量小于或等于0则隐藏减号和数量
        if (num <= 0) {
            $(this).next().css("display", "none");
            $(this).css("display", "none");
            jss();//改变按钮样式
            return
        }
    });

    function jss() {
        var m = $("#totalcountshow").html();
        if (m > 0) {
            $(".right").find("a").removeClass("disable");
        } else {
            $(".right").find("a").addClass("disable");
        }
    };
    //选项卡
    $(".con>div").hide();
    $(".con>div:eq(0)").show();

    $(".left-menu li").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var n = $(".left-menu li").index(this);
        $(".left-menu li").index(this);
        $(".con>div").hide();
        $(".con>div:eq(" + n + ")").show();
    });
});
*/