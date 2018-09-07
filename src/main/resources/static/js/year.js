
    /*向下拉框中填入数据*/
    $(function(){
        var dd = new Date();
        var currentYear = dd.getFullYear();
        var size = currentYear - 2002 + 1;
        //$("#years").append($("<option value="+999+">"+"全部"+"</option>"));
        for( var i=0; i<size; i++ ){
            var yearOld = currentYear-i;
            $("#years").append($("<option value="+yearOld+">"+yearOld+"年"+"</option>"));
        }
    });
/* 获取选中的下拉框的值 */
function yearSelected(){
    var valueSel = $("#years").find("option:selected").val();
    var textSel = $("#years").find("option:selected").text();
    console.info("选中的option的value值为："+valueSel);/* value值，如2017 */
    console.info("选中的option的text值为："+textSel);/* text值，如2017年 */
}

