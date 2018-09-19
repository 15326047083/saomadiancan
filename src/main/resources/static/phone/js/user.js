function getMyOrders() {
    $.ajax({
            url: "/orders/findOrdersByUserId",
            type: "post",
            dataType: "json",
            success(orders) {
                $("#main tr").remove();
                for (var i = 0; i < orders.length; i++) {
                    var td = "<td>" + orders[i].orderNum + "</td>\n" +
                        "        <td>" + new Date(parseInt(orders[i].generateTime)).toLocaleString().replace(/:\d{1,2}$/, ' ') + "</td>\n" +
                        "        <td>" + orders[i].deskNum + "</td>\n" +
                        "        <td>" + orders[i].peopleNum + "</td>\n" +
                        "        <td>￥" + orders[i].allPrice / 100 + "</td>";
                    $("#order tbody").append("<tr>" + td + "</tr>");
                }
            }
        }
    );
}

function getMyUserInfo() {
    $.ajax({
        type: "get",
        url: "/login/getMyUserInfo",
        dataType: "json",
        success(user) {
            if (user == null)
                window.location.href = "/empJump/toUserLogin";
            else {
                $("#userName").html(user.name);
                $("#userPhone").html(user.phone);
            }
        }
    });
}

var page = 1;
var allPage = 1;

function getUserList(p) {

    if (p >= 1 && p <= allPage) {
        page = p;
        $.ajax({
            url: "/login/listUser?page=" + p,
            type: "get",
            dataType: "json",
            success(data) {
                $("#main tr").remove();
                allPage = Math.ceil(data.total / data.size);
                for (var i = 0; i < data.rows.length; i++) {
                    var trtd = "<td>" + i + 1 + "</td><td>" + data.rows[i].name + "</td><td>" + data.rows[i].phone + "</td><td>"
                        + data.rows[i].integral + "</td>";
                    $("#table1 tbody").append("<tr>" + trtd + "</tr>");
                }
            }
        });
    }
}


//60秒后重新发送
function time() {
    var time = $("#time").text();
    //定时器
    t = setInterval(function () {
        time--;
        $("#time").html(time);
        if (time == 0) {
            $("#sendAgain").css("display", "none");
            $("#send").css("display", "block");
            $("#time").html("60");
            clearInterval(t);
            return;
        }
    }, 1000);

}

//点击发送按钮
function send() {
    if ($("#phone").val().length == 11) {
        $("#phone").attr("readonly", "readonly");
        $.ajax({
            type: "get",
            url: "/login/sendme",
            data: {
                "phone": $("#phone").val()
            },
            success(data) {
                if (data == "success") {
                    $("#send").css("display", "none");
                    $("#sendAgain").css("display", "block");
                    time();
                } else {
                    alert("手机号已存在，更换手机号或直接登陆！");
                }
            }
        })
        ;
    } else {
        alert("请输入正确的手机号!")
    }
}

function userRegister() {
    if ($('#name').val().length < 1) {
        alert("请填写姓名或昵称");
    } else if ($('#password').val().length < 6) {
        alert("密码不可以低于6为数");
    } else {
        $.ajax({
            type: 'post',
            url: '/login/comparecode',
            data: {
                'phone': $('#phone').val(),
                'name': $('#name').val(),
                'password': $('#password').val(),
                'code': $('#code').val()
            },
            success(data) {
                if (data == 'success') {
                    window.location.href = "/empJump/toGoodsList";
                } else {
                    alert('注册失败，请检查手机号和验证码是否正确！');
                }
            }
        });
    }
}