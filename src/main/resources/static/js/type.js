//商品表格显示
function goodstable() {
	$("#main").empty();
	/*$.ajax({
		type: "post",
		url: "/goods/toList",
		dataType: "json",
		error() {},
		success(json) {
			for(var i = 0; i < json.length; i++) {
				var t1 = $("#table1 tbody");
				var trtd = "<td><input type='checkbox' name='click' value='" + json[i].goodsId  + "' /></td><td>" + json[i].id + "</td><td>" + json[i].typeName  + "</td><td>" + json[i].typeName  + "</td><td>" + json[i].goodsPrice  +
					"</td><td>" + json[i].goodsDiscount + "</td><td>" + json[i].goodsStartTime + "</td><td>" + json[i].goodsEndTime + "</td>";
				var tdbutten = "<td><a href='/goods/toUpdate/" + json[i].goodsId +
					"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
					"<a href='/type/toList/" +json[i].goodsId+
					"'><button class='layui-btn layui-btn-primary layui-btn-small'>查看</button></a></td>";
				$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
			}
		}
	});
*/
	for(var i = 0; i < 5; i++) {
		var t1 = $("#table1 tbody");
		var trtd = "<td><input type='checkbox' name='click' value='" + i + "' /></td><td>" + i + "</td><td>" + i + "</td><td>" + i +
			"</td><td>" + i + "</td><td>" + i + "</td><td>" + i + "</td><td>" + i + "</td>";
		var tdbutten = "<td><a href='/type/toList/" + i +
			"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
			"<a href='/type/toList/" + i +
			"'><button class='layui-btn layui-btn-primary layui-btn-small'>查看</button></a></td>";
		$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
		
	}
}
//类型表格显示
function showtable() {
	$.ajax({
			type: "post",
			url: "/type/toList",
			dataType: "json",
			error() {},
			success(json) {

				for(var i = 0; i < json.length; i++) {
					var t1 = $("#table1 tbody");
					var trtd = "<td>" + json[i].id + "</td><td>" + json[i].name + "</td><td>" + json[i].num + "</td>";
					var tdbutten = "<td><a href='/zhengJump/toUpdate/"+json[i].id+
						"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
                        "<a onclick='deletet(" + json[i].id +
                        ")'><button class='layui-btn layui-btn-primary layui-btn-small'>删除</button></a></td>";
					$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
				}
			}
		});
	/*
	$("#main").empty();
	for(var i = 0; i < 5; i++) {
		var t1 = $("#table1 tbody");
		var trtd = "<td>" + i + "</td><td>" + i + "</td><td>" + i + "</td>";
		var tdbutten = "<td><a href='/type/toList/" + i +
			"'><button class='layui-btn layui-btn-primary layui-btn-small'>修改</button></a>" +
			"<button onclick='deletet(" + i + ")' class='layui-btn layui-btn-primary layui-btn-small'>删除</button></td>";
		$("#table1 tbody").append("<tr>" + trtd + tdbutten + "</tr>");
	}*/
}

function deletet(id) {
    if(confirm("真的要删除吗?")) {
        alert("点击了确认按钮");
        $.ajax({
            type: "post",
            url: "/type/delete/"+id,
            success: function(result) {
                if(result == 'success') {
                    alert("删除成功！");
                    window.location.href = "/zhengJump/toList";
                } else {
                    alert("删除失败！");
                }
            }
        });
    } else {
        return false;
    }

}



//类型修改前 显示原来的值
function toUpdate() {
    $.ajax({
        type: "post",
        url: "/type/toUpdate/"+$("#id").val(),
        dataType: "json",
        error() {},
        success(json) {
            $("#id").val(json.id);
            $("#name").val(json.name);

        }
    });
}


//批量删除
function deleteAll() {
	var num = 0;
	var arrayId;
	var start = 0;
	$("input[name='click']").each(function() {

		if($(this).prop('checked')) { //判断是否选择
			num = num + 1;
		}
	});
	if(num == 0) {
		alert("请选择数据");
	} else if(num > 0) {
		//删除前判断
		if(confirm("真的要删除吗?")) {
			$("input[name='click']").each(function() { //判断是否被选
				if(start == 0) {
					arrayId = $(this).val() + ',';
				} else {
					arrayId += $(this).val() + ',';
				}
				start += 1;
			});
			//alert("点击了确认按钮");
			$.ajax({
				type: "POST",
				url: "/goods/delete",
				data: {
					'list': checkedList
				},
				success: function(result) {
					if(result == 'success') {
						alert("删除成功！");
						showtable();
					} else {
						alert("删除失败！");
					}
				}
			});

		} else {
			return false;
		}

	}
	return arrayId;
}