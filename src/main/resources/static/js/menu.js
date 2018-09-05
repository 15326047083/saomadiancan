//添加左侧菜单
function addMenu() {
	$.ajax({
		type: "get",
		url: "/roles/toList",
		dataType: "json",
		error() {

		},
		success(json) {
			var meanName = json.meanName;
			var meanUrl = json.meanUrl;
			var leng = json.length;

			var u = $("#menu");
			for(var i = 0; i < leng; i++) {
				u.append("<dd><a href='javascript:;'><i class='layui-icon'>&#xe621;</i>" + meanName + "</a></dd>");
				$("#menu dd a").attr("href-url", meanUrl);
			}
		}
	});
}
//修改前 显示原来的值
function toUpdate() {
	$.ajax({
		type: "post",
		url: "/roles/toUpdate",
		dataType: "json",
		error() {},
		success(json) {
			$("#id").val(json.id);
			$("#name").val(json.name);
			$("#meanName").val(json.meanName);
			$("#meanUrl").val(json.meanUrl);
		}
	});
}
//表格显示
function showtable() {
	$.ajax({
		type: "post",
		url: "/roles/toUpdate",
		dataType: "json",
		error() {},
		success(json) {

			for(var i = 0; i < json.length; i++) {
				var t1 = $("#table1 tbody");
				var trtd = "<td>" + json[i].id + "</td><td>" + json[i].name + "</td><td>" + json[i].meanName + "</td><td>" + json[i].meanUrl + "</td>";
				var tdbutten = "<td><a href='/roles/toUpdate/"+json[i].id+
					"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
					"<a href='/roles/delete/" +json[i].id+
					"'><button class='layui-btn layui-btn-primary layui-btn-small'>删除</button></a></td>";
				$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
			}
		}
	});
}