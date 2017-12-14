var Script = function () {


    
    
    var barChartData = {
        labels : ["星期一","星期二","星期三","星期四","星期五","星期六","星期天"],
        datasets : [
            {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                data : [28,48,40,19,96,27,100]
            }
        ]

    };
    
    
    new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
    


}();