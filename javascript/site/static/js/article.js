/**
 * Created by Morn on 14-3-7.
 */

/****************** 添加收藏夹 **********************/
var browserEvent = function (obj, url, title) {
    var e = window.event || arguments.callee.caller.arguments[0];
    var B = {
        IE : /MSIE/.test(window.navigator.userAgent) && !window.opera,
        FF : /Firefox/.test(window.navigator.userAgent),
        OP : !!window.opera
    };
    obj.onmousedown = null;
    if (B.IE) {
		var url = 'http://blog.hray.info/?utm_source=shoucangjia&utm_medium=IE& utm_campaign=header';
        obj.attachEvent("onmouseup", function () {
            try {
                window.external.AddFavorite(url, title);
                window.event.returnValue = false;
            } catch (exp) {}
        });
    } else {
        if (B.FF || obj.nodeName.toLowerCase() == "a") {
			if (window.sidebar) {
            	obj.setAttribute("rel", "sidebar"), obj.title = title, obj.href = url;
			} else {
				alert ('请用快捷键 Ctrl+D 加入收藏.');
			}
        } else if (B.OP) {
            var a = document.createElement("a");
            a.rel = "sidebar", a.title = title, a.href = url;
            obj.parentNode.insertBefore(a, obj);
            a.appendChild(obj);
            a = null;
        }
    }
}

/******************** 鼠标滚动 *********************/
function handle(delta, t) {
    var s = delta + ": ";
    if (!t) {
        t = window.scrollY ? window.scrollY : $(document).scrollTop();
    }
    var h = $('#header').height();
    if (delta < 0) {
        if (t >= h) {
            $('#sitenav').css({
                'position': 'fixed',
                'top': '0'
            })
            $('#s2top').css({
                'display': 'block'
            })
         }
    } else {
        if (t > h) {
            $('#sitenav').css({
                'position': 'fixed',
                'top': '0'
            })
            $('#s2top').css({
                'display': 'block'
            })
        } else if (t <= h) {
            $('#sitenav').css({
                'position': 'static',
                'top': 'auto'
            })
            $('#s2top').css({
                'display': 'none'
            })
        }
    }
}

function wheel(event) {
    var delta = 0;
    var e = event ? event : window.event;
    if (e.wheelDelta) {
        delta = e.wheelDelta / 120;
        if (window.opera) delta = -delta;
    } else if (e.detail) {
        delta = -e.detail / 3;
    }
    if (delta)
        handle(delta);
}

if (document.addEventListener) {
    document.addEventListener('DOMMouseScroll', wheel, false);
}
window.onmousewheel = document.onmousewheel = wheel;

// 这一段处理直接拖动滚动条的处理
var sign = 10;
$(window).bind('scroll', function (e) {
    var h1 = $('#header').height();
    var scrtop = document.documentElement.scrollTop || document.body.scrollTop;
    var height = document.documentElement.clientHeight || document.body.clientHeight;

    if (scrtop > sign) {
        sign = scrtop;
        if (scrtop > h1) {
            handle(-1);
        }
    }
    if (scrtop < sign) {
        sign = scrtop;
        handle(1);
    }
})

/**
 * 回到页面顶部
 * @param acceleration 加速度
 * @param time 时间间隔 (毫秒)
 **/
function goTop(acceleration, time) {
	acceleration = acceleration || 0.1;
	time = time || 16;

	var x1 = 0;
	var y1 = 0;
	var x2 = 0;
	var y2 = 0;
	var x3 = 0;
	var y3 = 0;

	if (document.documentElement) {
		x1 = document.documentElement.scrollLeft || 0;
		y1 = document.documentElement.scrollTop || 0;
	}
	if (document.body) {
		x2 = document.body.scrollLeft || 0;
		y2 = document.body.scrollTop || 0;
	}
	var x3 = window.scrollX || 0;
	var y3 = window.scrollY || 0;

	// 滚动条到页面顶部的水平距离
	var x = Math.max(x1, Math.max(x2, x3));

	// 滚动条到页面顶部的垂直距离
	var y = Math.max(y1, Math.max(y2, y3));

	// 滚动距离 = 目前距离 / 速度, 因为距离原来越小, 速度是大于 1 的数, 所以滚动距离会越来越小
	var speed = 1 + acceleration;
	window.scrollTo(Math.floor(x / speed), Math.floor(y / speed));

    // 特殊处理导航条复位
    var h = $('#header').height();
    if (y <= h) {
        handle(0, 0)
    }

	// 如果距离不为零, 继续调用迭代本函数
	if(x > 0 || y > 0) {
		var invokeFunction = "goTop(" + acceleration + ", " + time + ")";
		window.setTimeout(invokeFunction, time);

	}
}
