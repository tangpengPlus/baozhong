var Script = function () {

    //morris chart

    $(function () {
      // data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type
      var tax_data = [
    	  [#list]
           {"period": "2017-05-05 01:00", "流水": '${test.income}'}
           [#/list]
      ];
      Morris.Line({
          element: 'hero-graph',
          data: tax_data,
          xkey: 'period',
          ykeys: ['流水'],
          labels: ['流水'],
          lineColors:['#8075c4','#6883a3']
        });
        
         Morris.Bar({
          element: 'hero-bar',
          data: tax_data,
          xkey: 'period',
          ykeys: ['流水'],
          labels: ['流水'],
          barRatio: 0.4,
          xLabelAngle: 35,
          hideHover: 'auto',
          barColors: ['#6883a3']
        });
    });
}();
