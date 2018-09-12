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
                document.getElementById("span").innerHTML = page + "/" + allPage;
                for (var i = 0; i < data.rows.length; i++) {
                    var trtd = "<td>" + i + 1 + "</td><td>" + data.rows[i].name + "</td><td>" + data.rows[i].phone + "</td><td>"
                        + data.rows[i].integral + "</td>";
                    $("#table1 tbody").append("<tr>" + trtd + "</tr>");
                }
            }
        });
    }
}