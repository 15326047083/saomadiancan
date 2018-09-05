//添加左侧菜单
function addMenu() {
	$.ajax({
		type: "get",
		url: "/roles/getMean",
		dataType: "json",
		error() {

		},
		success(json) {
			var leng = json.length;

			var u = $("#menu");
			for(var i = 0; i < leng; i++) {
				u.append("<dd><a href='javascript:;'><i class='layui-icon'>&#xe621;</i>" + json[i].meanName + "</a></dd>");
				$("#menu dd a").attr("href-url", json[i]. meanUrl);

			}
		}
	});
}
//修改前 显示原来的值
function toUpdate() {
	$.ajax({
		type: "post",
		url: "/roles/toUpdate/"+$("#id").val(),
		dataType: "json",
		error() {},
		success(json) {
            $("#id").val(json.id);
            $("#name").val(json.name);
            $("#meanName").val(json.meanName);
        }
	});
}
//表格显示
function showtable() {

	$.ajax({
		type: "post",
		url: "/roles/toList",
		dataType: "json",
		error() {},
		success(json) {
			$("#main tr").remove();
			for(var i = 0; i < json.length; i++) {
				var t1 = $("#table1 tbody");
				var trtd = "<td>" + json[i].id + "</td><td>" + json[i].name + "</td><td>" + json[i].meanName + "</td><td>" + json[i].meanUrl + "</td>";
				var tdbutten = "<td><a href='/jump/toMenuUpdate/"+json[i].id+
					"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
					"<button onclick='deleteById(" +json[i].id+")' class='layui-btn layui-btn-primary layui-btn-small'>删除</button></td>";
				$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
			}
		}
	});
}
function deleteById(id) {
	$.ajax({
        type: "get",
        url: "/roles/delete/"+id,
        dataType: "json",
        error() {
            alert("删除成功");
            showtable();

        },
        success(json) {
        	alert("删除成功");
            showtable();
        }
	})

}

