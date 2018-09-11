// 列表动态展示 通过ajax动态获取列表信息
function showTable() {
    $.ajax({
        type: "get",
        url: "/emp/toList",
        dataType: "json",
        error() {
        },
        success(json) {

            for (var i = 0; i < json.length; i++) {
                var t1 = $("#table1 tbody");
                var trtd = "<td>" + json[i].id + "</td><td>" + json[i].name + "</td>" + "<td>" + json[i].roles + "</td>" + "<td>" + json[i].username + "</td><td>" +
                    json[i].password + "</td>" + "<td>" + json[i].entryTime + "</td>" + "<td>" + json[i].wage + "</td>" + "<td>" + json[i].ticheng + "</td>";
                var tdbutten = "<td><a href='/empJump/toEmpUpdate/" + json[i].id +
                    "'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
                    "<a onclick='deleteEmp(" + json[i].id +
                    ")'><button class='layui-btn layui-btn-primary layui-btn-small'>离职</button></a></td>";
                $("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
            }
        }
    });
}

function deleteEmp(empId) {
    $.ajax({
        type: "get",
        url: "/emp/delete/" + empId,
        success() {
            alert("删除成功");
            window.location.href = "/empJump/toEmpList";
        }
    });
}

// 获取需要修改的员工信息
function getEmp() {
    var roles;
    $.ajax({
        type: "get",
        url: "/emp/toUpdate/" + $("#empId").val(),
        dataType: "json",
        error() {
        },
        success(json) {
            $("#id").val(json.id);
            $("#name").val(json.name);
            $("#username").val(json.username);
            $("#password").val(json.password);
            $("#wage").val(json.wage);
            $("#ticheng").val(json.ticheng);
            roles = json.roles;
        }
    });
    var selectBj = "";
    $.ajax({
        type: "get",
        url: "/roles/getRolesList",
        dataType: "json",
        error() {
        },
        success(json) {
            for (var i = 0; i < json.length; i++) {
                if (json[i] == roles) {
                    selectBj = "selected='selected'";
                }
                $("#roles").append("<option value='" + json[i] + "'" + selectBj + ">" + json[i] + "</option>");
            }
            layui.form.render('select');
        }
    });
}
//查看个人信息
function getEmpby() {
    $.ajax({
        type: "get",
        url: "/emp/toUpdate/"+$("#empid").val() ,
        dataType: "json",
        error() {
        },
        success(json) {
            $("#id").val(json.id);
            $("#name").val(json.name);
            $("#username").val(json.username);
            $("#password").val(json.password);
            $("#wage").val(json.wage);
            $("#ticheng").val(json.ticheng);
            $("#roles").val(json.roles);
        }
    });

}
// 获取角色去重列表
function getRolesList() {
    $.ajax({
        type: "get",
        url: "/roles/getRolesList",
        dataType: "json",
        error() {
        },
        success(json) {
            for (var i = 0; i < json.length; i++) {
                $("#roles").append("<option value='" + json[i] + "'" + ">" + json[i] + "</option>");
            }
            layui.form.render('select');
        }
    });
}