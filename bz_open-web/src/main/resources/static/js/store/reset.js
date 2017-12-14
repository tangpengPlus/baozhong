/**
 * @author 大表哥
 */
!function (a) {
	function b() {
		a.rem = f.getBoundingClientRect().width / 18.75,
		f.style.fontSize = a.rem + "px"
	}
	var c,
	d = a.navigator.appVersion.match(/iphone/gi) ? a.devicePixelRatio : 1,
	e = 1 / d,
	f = document.documentElement,
	g = document.createElement("meta");
	if (a.dpr = d, a.addEventListener("resize", function () {
			clearTimeout(c),
			c = setTimeout(b, 300)
		}, !1), a.addEventListener("pageshow", function (a) {
			a.persisted && (clearTimeout(c), c = setTimeout(b, 300))
		}, !1), f.setAttribute("data-dpr", d), g.setAttribute("name", "viewport"), g.setAttribute("content", "initial-scale=" + e + ", maximum-scale=" + e + ", minimum-scale=" + e + ", user-scalable=no"), f.firstElementChild)
		f.firstElementChild.appendChild(g);
	else {
		var h = document.createElement("div");
		h.appendChild(g),
		document.write(h.innerHTML)
	}
	b()
}(window);

//qq手机reset    js
/**
	(function() {
        var baseFontSize = 100;
        var baseWidth = 320;
        var clientWidth = document.documentElement.clientWidth || window.innerWidth;
        var innerWidth = Math.max(Math.min(clientWidth, 480), 320);

        var rem = 100;

        if (innerWidth > 362 && innerWidth <= 375) {
            rem = Math.floor(innerWidth / baseWidth * baseFontSize * 0.9);
        }
        
        if (innerWidth > 375) {
            rem = Math.floor(innerWidth / baseWidth * baseFontSize * 0.84);
        }

        window.__baseREM = rem;
        document.querySelector('html').style.fontSize = rem + 'px';
    }());
**/
