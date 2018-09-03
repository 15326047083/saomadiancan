function getUser() {
    $.ajax({
        url: "/user/getUserList",
        dataType: "json",
        success(userList) {
            var div = document.getElementById("main");
            $("#main").empty();
            var table = document.createElement("table");
            table.style.border = "1";
            table.id = "userTable";
            var tr = document.createElement("tr");
            table.appendChild(tr);
            var th = document.createElement("th");
            th.innerHTML = "用户名";
            tr.appendChild(th);
            var th = document.createElement("th");
            th.innerHTML = "ID";
            tr.appendChild(th);
            var th = document.createElement("th");
            th.innerHTML = "操作";
            tr.appendChild(th);
            for (var i in userList) {
                var tr = document.createElement("tr");
                table.appendChild(tr);
                var td = document.createElement("td");
                td.innerHTML = userList[i].name;
                tr.appendChild(td);
                var td = document.createElement("td");
                td.innerHTML = userList[i].id;
                tr.appendChild(td);
                var td = document.createElement("td");
                td.innerHTML = "<a href='javascript:' onclick='getUserById(" + userList[i].id + ")'>查看</a>";
                tr.appendChild(td);
            }
            div.appendChild(table);
        }
    });
}

function getUserById(ID) {
    $.ajax({
        url: "/user/getUserById/" + ID,
        type: "get",
        dataType: "json",
        success(data) {
            var div = document.getElementById("main");
            $("#main").empty();
            var span = document.createElement("span");
            span.innerHTML = data.name;
            div.appendChild(span);
        }
    });
}