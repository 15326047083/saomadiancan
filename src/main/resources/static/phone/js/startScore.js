var score1;
var score2;
var score3;

function scoreFun1(object, opts) {
    var defaults = {
        fen_d: 16,
        ScoreGrade: 10,
        types: ["环境评分：1分", "环境评分：2分", "环境评分：3分", "环境评分：4分", "环境评分：5分", "环境评分：6分", "环境评分：7分", "环境评分：8分", "环境评分：9分", "环境评分：10分", "环境评分：10分"],
        nameScore: "fenshu",
        parent: "star_score",
        attitude: "attitude"
    };
    options = $.extend({}, defaults, opts);
    var countScore = object.find("." + options.nameScore);
    var startParent = object.find("." + options.parent);
    var atti = object.find("." + options.attitude);
    var now_cli;
    var fen_cli;
    var atu;
    var fen_d = options.fen_d;
    var len = options.ScoreGrade;

    startParent.width(fen_d * len);
    var preA = (5 / len);
    for (var i = 0; i < len; i++) {
        var newSpan = $("<a href='javascript:void(0)'></a>");
        newSpan.css({
            "left": 0,
            "width": fen_d * (i + 1),
            "z-index": len - i
        });
        newSpan.appendTo(startParent)
    }
    startParent.find("a").each(function (index, element) {

        $(this).click(function () {
            now_cli = index;
            show(index, $(this))
        });
        $(this).mouseenter(function () {
            show(index, $(this))
        });
        $(this).mouseleave(function () {
            if (now_cli >= 0) {
                var scor = preA * (parseInt(now_cli) + 1);
                startParent.find("a").removeClass("clibg");
                startParent.find("a").eq(now_cli).addClass("clibg");
                var ww = fen_d * (parseInt(now_cli) + 1);
                startParent.find("a").eq(now_cli).css({
                    "width": ww,
                    "left": "0"
                });
                if (countScore) {
                    countScore.text(scor)
                }
            } else {
                startParent.find("a").removeClass("clibg");
                if (countScore) {
                    countScore.text("")
                }
            }
        })
    });

    function show(num, obj) {

        var n = parseInt(num) + 1;

        var lefta = num * fen_d;
        var ww = fen_d * n;
        var scor = preA * n;
        atu = options.types[parseInt(num)];
        object.find("a").removeClass("clibg");
        obj.addClass("clibg");
        obj.css({
            "width": ww,
            "left": "0"
        });
        countScore.text(scor);
        atti.text(atu)
        $("#score1").html(num + 1);
        score1=num+1;
    }

};

function scoreFun2(object, opts) {
    var defaults = {
        fen_d: 16,
        ScoreGrade: 10,
        types: ["服务评分：1分", "服务评分：2分", "服务评分：3分", "服务评分：4分", "服务评分：5分", "服务评分：6分", "服务评分：7分", "服务评分：8分", "服务评分：9分", "服务评分：10分", "服务评分：10分"],
        nameScore: "fenshu",
        parent: "star_score",
        attitude: "attitude"
    };
    options = $.extend({}, defaults, opts);
    var countScore = object.find("." + options.nameScore);
    var startParent = object.find("." + options.parent);
    var atti = object.find("." + options.attitude);
    var now_cli;
    var fen_cli;
    var atu;
    var fen_d = options.fen_d;
    var len = options.ScoreGrade;

    startParent.width(fen_d * len);
    var preA = (5 / len);
    for (var i = 0; i < len; i++) {
        var newSpan = $("<a href='javascript:void(0)'></a>");
        newSpan.css({
            "left": 0,
            "width": fen_d * (i + 1),
            "z-index": len - i
        });
        newSpan.appendTo(startParent)
    }
    startParent.find("a").each(function (index, element) {

        $(this).click(function () {
            now_cli = index;
            show(index, $(this))
        });
        $(this).mouseenter(function () {
            show(index, $(this))
        });
        $(this).mouseleave(function () {
            if (now_cli >= 0) {
                var scor = preA * (parseInt(now_cli) + 1);
                startParent.find("a").removeClass("clibg");
                startParent.find("a").eq(now_cli).addClass("clibg");
                var ww = fen_d * (parseInt(now_cli) + 1);
                startParent.find("a").eq(now_cli).css({
                    "width": ww,
                    "left": "0"
                });
                if (countScore) {
                    countScore.text(scor)
                }
            } else {
                startParent.find("a").removeClass("clibg");
                if (countScore) {
                    countScore.text("")
                }
            }
        })
    });

    function show(num, obj) {

        var n = parseInt(num) + 1;

        var lefta = num * fen_d;
        var ww = fen_d * n;
        var scor = preA * n;
        atu = options.types[parseInt(num)];
        object.find("a").removeClass("clibg");
        obj.addClass("clibg");
        obj.css({
            "width": ww,
            "left": "0"
        });
        countScore.text(scor);
        atti.text(atu)
        $("#score2").html(num + 1);
        score2=num+1;
    }

};

function scoreFun3(object, opts) {
    var defaults = {
        fen_d: 16,
        ScoreGrade: 10,
        types: ["味道评分：1分", "味道评分：2分", "味道评分：3分", "味道评分：4分", "味道评分：5分", "味道评分：6分", "味道评分：7分", "味道评分：8分", "味道评分：9分", "味道评分：10分", "味道评分：10分"],
        nameScore: "fenshu",
        parent: "star_score",
        attitude: "attitude"
    };
    options = $.extend({}, defaults, opts);
    var countScore = object.find("." + options.nameScore);
    var startParent = object.find("." + options.parent);
    var atti = object.find("." + options.attitude);
    var now_cli;
    var fen_cli;
    var atu;
    var fen_d = options.fen_d;
    var len = options.ScoreGrade;

    startParent.width(fen_d * len);
    var preA = (5 / len);
    for (var i = 0; i < len; i++) {
        var newSpan = $("<a href='javascript:void(0)'></a>");
        newSpan.css({
            "left": 0,
            "width": fen_d * (i + 1),
            "z-index": len - i
        });
        newSpan.appendTo(startParent)
    }
    startParent.find("a").each(function (index, element) {

        $(this).click(function () {
            now_cli = index;
            show(index, $(this))
        });
        $(this).mouseenter(function () {
            show(index, $(this))
        });
        $(this).mouseleave(function () {
            if (now_cli >= 0) {
                var scor = preA * (parseInt(now_cli) + 1);
                startParent.find("a").removeClass("clibg");
                startParent.find("a").eq(now_cli).addClass("clibg");
                var ww = fen_d * (parseInt(now_cli) + 1);
                startParent.find("a").eq(now_cli).css({
                    "width": ww,
                    "left": "0"
                });
                if (countScore) {
                    countScore.text(scor)
                }
            } else {
                startParent.find("a").removeClass("clibg");
                if (countScore) {
                    countScore.text("")
                }
            }
        })
    });

    function show(num, obj) {

        var n = parseInt(num) + 1;

        var lefta = num * fen_d;
        var ww = fen_d * n;
        var scor = preA * n;
        atu = options.types[parseInt(num)];
        object.find("a").removeClass("clibg");
        obj.addClass("clibg");
        obj.css({
            "width": ww,
            "left": "0"
        });
        countScore.text(scor);
        atti.text(atu)
        $("#score3").html(num + 1);
        score3=num+1;
    }

};