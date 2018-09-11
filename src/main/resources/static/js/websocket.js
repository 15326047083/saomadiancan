var websocket = null;
//浏览器是否支持
if ('WebSocket' in window) {
    websocket = new WebSocket('ws://localhost:8080/webSocket');
} else {
    alert('该浏览器不支持websocket!');
}
//建立连接
websocket.onopen = function (event) {
    console.log('建立连接');
}
//关闭连接
websocket.onclose = function (event) {
    console.log('连接关闭');
}
//消息来的时候的事件
websocket.onmessage = function (event) {
    console.log('收到消息:' + event.data);
    $("#mp3").empty();
    if (event.data == "1") {
        $("#mp3").append("<audio src=\"/mp3/1.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "2") {
        $("#mp3").append("<audio src=\"/mp3/2.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "3") {
        $("#mp3").append("<audio src=\"/mp3/3.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "4") {
        $("#mp3").append("<audio src=\"/mp3/4.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "5") {
        $("#mp3").append("<audio src=\"/mp3/5.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "6") {
        $("#mp3").append("<audio src=\"/mp3/6.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else if (event.data == "7") {
        $("#mp3").append("<audio src=\"/mp3/7.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    } else {
        $("#mp3").append("<audio src=\"/mp3/order.mp3\" id=\"myaudio\" controls=\"controls\" loop=\"false\" hidden=\"false\"></audio>");
    }
    document.getElementById('myaudio').play();
    setTimeout(function () {
        var myAuto = document.getElementById('myaudio');
        myAuto.pause();
        myAuto.load();
    }, 5000);
}
//发生错误时
websocket.onerror = function () {
    alert('websocket通信发生错误！');
}
//窗口关闭时，Websocket关闭
window.onbeforeunload = function () {
    websocket.close();
}