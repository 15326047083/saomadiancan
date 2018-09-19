//获取星星数量
function getstar(num) {
    var str = "";
    for(var i = 0; i < num / 6; i++) {
        str = str + "<img src='/phone/img/shoucang1.png'/>";
    }
    return str;
}
var page = 1;
var allPage = 1;

//获取列表
function getDiscussList(p) {
    $("#downShow").remove();
    var str1="<dd><div class=\"evaluate\"><div class=\"evaluate-fl\"><span><img src=\"/phone/img/people.png\"/></span><span><p>匿名评论</p><p class=\"color999\">";
    //评论时间
    var disTime="";
    var str2="</p></span></div><div class=\"evaluate-fr\">";
    //获取星星
    var star="";
    var str3="</div></div><div class=\"evaluate-text\">";
    var disscuss="";
    var str4="</div>" ;

    var str5="<div style=\"margin-left: 30px;\"><div class=\"evaluate\"><div class=\"evaluate-fl\"><span><p class=\"color999\">商家回复:";
    //商家回复时间
    var replyTime="";
    var str6="</p></span></div></div><div class=\"evaluate-text\">";
    //商家回复
    var reply="";
    var str7="</div></div>";
    var str8="</dd>";
    if (p >= 1 && p <= allPage) {
        page = p;
    $.ajax({
        type: "get",
        url: "/discuss/DiscussList?page=" + p,
        dataType: "json",
        success(data) {

            allPage = Math.ceil(data.total / data.size);

            for (var i=0;i<data.rows.length;i++){
                disTime= new Date(parseInt(data.rows[i].discussTime)).toLocaleString().replace(/:\d{1,2}$/, ' ');
                disscuss=data.rows[i].discussInfo;
                star=getstar(data.rows[i].discussEnLevel+data.rows[i].discussServiceLevel+data.rows[i].discussQuLevel);
                if (data.rows[i].replyId>0){
                    replyTime= new Date(parseInt(data.rows[i].replyTime)).toLocaleString().replace(/:\d{1,2}$/, ' ');
                    reply=data.rows[i].replyInfo;
                    $("#main").append(str1+disTime+str2+star+str3+disscuss+str4+str5+replyTime+str6+reply+str7+str8);
                }
                else {
                    $("#main").append(str1+disTime+str2+star+str3+disscuss+str4+str8);
                }
            } //下拉样式
            $("#main").append("<div id='downShow' style='width: 100%;height: 40px;margin-bottom: 50px;text-align: center' onclick='getDiscussList(page+1)'><a style='color: grey;font-size: 14px;top: 10px;'>加载更多...</a></div>");
        }
    });

    }
}