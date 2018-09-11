
window.onload=function(){
//设置年份的选择
        var myDate= new Date();
        var startYear=myDate.getFullYear()-20;//起始年份
        var endYear=myDate.getFullYear()+20;//结束年份
        var obj=document.getElementById('year')
        for (var i=startYear;i<=endYear;i++)
        {
            obj.options.add(new Option(i,i));
        }
        obj.options[obj.options.length-51].selected=1;
    }


