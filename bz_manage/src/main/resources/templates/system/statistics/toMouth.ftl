<!DOCTYPE html>
<html lang="en">
  <head>
 [#include "/base/base.ftl"/]
 
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="${base}/img/favicon.png">

    <!-- Bootstrap core CSS -->
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${base}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${base}/assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <link href="${base}/css/style-responsive.css" rel="stylesheet" />
  
  
  
  
  	<style>
  body{padding: 20px;}
  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
  .demo-footer{padding: 50px 0; color: #999; font-size: 14px;}
  .demo-footer a{padding: 0 5px; color: #01AAED;}
  </style>
  </head>
  <body>
  <section id="container" class="">
      [#include "/base/header.ftl"/]
      <!--header end-->
      [#include "/base/left.ftl"/]
      <section id="main-content">
          <section class="wrapper">
                   [#include "/base/crumbs.ftl"/]
            <form method="get">   
              <div class="form-group" id="chartjs">
                 <input type="text" class="demo-input" placeholder="请选择日期" id="test1" name="beginTime">
                  <input type="text" class="demo-input" placeholder="请选择日期" id="test2" name="endTime">
                 <button class="btn btn-danger" type="submit">查询</button>
              </div>
            </form> 
                  <div id="morris">
                  <div class="row">
                      <div class="col-lg-10">	
                          <section class="panel">
                              <header class="panel-heading">
                          		Multiple Select
                          		<span class="tools pull-right">
                            		<a href="javascript:;" class="icon-chevron-down"></a>
                            		<a href="javascript:;" class="icon-remove"></a>
                          		</span>
                      		  </header>
                              <div class="panel-body">
                                  <div id="hero-graph" class="graph"></div>
                              </div>
                          </section>
                      </div>
                      <div class="tab-pane" id="chartjs">
                  					<div class="row">
                      					<div class="col-lg-9">
                          					<section class="panel">
                              					<header class="panel-heading">
                                  					流水对比分析
                              					</header>
                              					<div class="panel-body text-center">
                                  					<canvas id="bar" height="300" width="1000"></canvas>
                              					</div>
                          					</section>
                      					</div>
                  					</div>
              					</div>
                  </div>
               	 	</div>
          </section>
      </section>
      <!--main content end-->
      <!--footer start-->
      [#include "/base/footer.ftl"/]
      <!--footer end-->
  </section>
 	 <!-- js placed at the end of the document so the pages load faster -->
    <script src="${base}/js/jquery.js"></script>
    <script src="${base}/js/jquery-1.8.3.min.js"></script>
    <script src="${base}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${base}/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
    <script src="${base}/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
    <script src="${base}/js/respond.min.js" ></script>
    <script src="${base}/assets/chart-master/Chart.js"></script>
    
    <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>

    
    <script src="${base}/laydate/laydate.js"></script> <!-- 改成你的路径 -->
    
    
    
   <script>
   var Script = function () {
	    var label = [
	    		[#if list ??]
	    			[#list month as data]
	    				${data.beginDate},
	    			[/#list]
	    		[#else]
	    		"1号","2号","3号","4号","5号","6号","7号","8号","9号","10号","11号","12号","13号","14号","15号","16号","17号","18号","19号","20号","21号","22号","23号","24号","25号","26号","27号","28号","29号","30号","31号"
	    		[/#if]		
	    ]
	 
	 	var data1 = [
				[#list month as data]
					${data.beginData},
				[/#list]
	 	]
	 
		var data2 = [
				[#list month as data]
					  ${data.endData},
				[/#list]
		]
		 var barChartData = {
	        labels : label,
	        datasets : [
	            {
	                fillColor : "rgba(238,220,130,0.5)",
	                strokeColor : "rgba(205,190,112,1)",
	                data : data1
	            },
	            {
	                fillColor : "rgba(151,187,205,0.5)",
	                strokeColor : "rgba(151,187,205,1)",
	                data : data2
	            }
	        ]

	    };
	    
	    new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
	}();
   
   var Script = function () {
	    $(function () {
	      [#list month as datas]
	    //sdsd
	      [/#list]
	      
	      var tax_data = [
	    	  [#list month as data]
	      		{"period": "${data.beginDate}", "licensed": "${data.beginData}", "sorned": "${data.endData}"},
	          [/#list]
	      ];
	      Morris.Line({
	          element: 'hero-graph',
	          data: tax_data,
	          xkey: 'period',
	          ykeys: ['licensed' ,'sorned'],
	          labels: ['licensed' , 'Off the road'],
	          lineColors:['#8075c4','#BF3EFF']
	        });
	    });
	}();
	
		lay('#version').html('-v'+ laydate.v);

		//执行一个laydate实例
		laydate.render({
  		elem: '#test1' //指定元素
  		,type: 'month'
  		,range: '~'
  		,change: function(value, date, endDate){
  		    console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
  		    console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
  		  }
		});
	</script>
  </body>
</html>