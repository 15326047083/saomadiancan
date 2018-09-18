//添加左侧菜单
function addMenu() {
	//$("#menu").remove();
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
				u.append("<dd><a href='javascript:;' href-url='"+ json[i]. meanUrl+"'>" + json[i].meanName + "</a></dd>");
			}
            layui.element.init();
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
    layui.define(['layer', 'element'], function (exports) {
        // 操作对象
        var layer = layui.layer
            , element = layui.element
            , $ = layui.jquery;

        // 封装方法
        var mod = {
            // 添加 HTMl
            addHtml: function (addr, obj, treeStatus, data) {
                // 请求数据
                $.get(addr, data, function (res) {
                    var view = "";
                    if (res.data) {
                        $(res.data).each(function (k, v) {
                            v.subset && treeStatus ? view += '<li class="layui-nav-item layui-nav-itemed">' : view += '<li class="layui-nav-item">';
                            if (v.subset) {
                                view += '<a href="javascript:;"><i class="layui-icon">' + v.icon + '</i>' + v.text + '</a><dl class="layui-nav-child">';
                                $(v.subset).each(function (ko, vo) {
                                    view += '<dd>';
                                    if(vo.target){
                                        view += '<a href="' + vo.href + '" target="_blank">';
                                    }else{
                                        view += '<a href="javascript:;" href-url="' + vo.href + '">';
                                    }
                                    view += '<i class="layui-icon">' + vo.icon + '</i>' + vo.text + '</a></dd>';
                                });
                                view += '<dl>';
                            } else {
                                if (v.target) {
                                    view += '<a href="' + v.href + '" target="_blank">';
                                } else {
                                    view += '<a href="javascript:;" href-url="' + v.href + '">';
                                }
                                view += '<i class="layui-icon">' + v.icon + '</i>' + v.text + '</a>';
                            }
                            view += '</li>';
                        });
                    } else {
                        layer.msg('接受的菜单数据不符合规范,无法解析');
                    }
                    // 添加到 HTML
                    $(document).find(".layui-nav[lay-filter=" + obj + "]").html(view);
                    // 更新渲染
                    element.init();
                },'json');
            }
            // 左侧主体菜单 [请求地址,过滤ID,是否展开,携带参数]
            , main: function (addr, obj, treeStatus, data) {
                // 添加HTML
                this.addHtml(addr, obj, treeStatus, data);
            }
            // 顶部左侧菜单 [请求地址,过滤ID,是否展开,携带参数]
            , top_left: function (addr, obj, treeStatus, data) {
                // 添加HTML
                this.addHtml(addr, obj, treeStatus, data);
            }
            /*// 顶部右侧菜单
             ,top_right: function(){

             }*/
        };

        // 输出
        exports('vip_nav', mod);
    });
}
function deleteById(id) {
	$.ajax({
        type: "get",
        url: "/roles/delete/"+id,
        error() {

        },
        success(json) {
        	alert("删除成功");
            showtable();
        }
	})

}

