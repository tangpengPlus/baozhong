<!DOCTYPE html>
<html lang="en">
  <head>
 [#include "/base/base.ftl"/]
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${base}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
              <!-- page start-->
              <section class="panel">
                   [#include "/base/crumbs.ftl"/]
                  <div class="panel-body">
                      <div class="adv-table editable-table ">
                      	  <form action="#" class="form-horizontal tasi-form">
                      	  	<span class="numeric">请选择要对比的日期1：</span><input type="text" class="demo-input" id="test1" name="test1">
                      	  	<span class="numeric">请选择要对比的日期2：</span><input type="text" class="demo-input" id="test2">
                            <button class="btn btn-danger" style="margin-left:10px;height:37px" type="submit">查询</button>
                          </form>
                          <div class="space15"></div>
                           <div class="panel-body">
                              <section class="wrapper" style="margin-top:0px">
              					<!-- page start-->
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
          					</section>
                          </div>
                      </div>
                  </div>
              </section>
              <!-- page end-->
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
    <script src="${base}/assets/chart-master/Chart.js"></script>
    <script src="${base}/js/respond.min.js" ></script>
 	<script src="${base}/js/layDate/laydate.js"></script>
 	
    <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>

    <!-- script for this page only-->
    <script src="${base}/js/mychart.js"></script>
    
   
    
 <script>
 
 var Script = function () {
    var label = [
    		[#if list ??]
    			[#list list as li]
    				${li.id2},
    			[/#list]
    		[#else]
    			"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"
    		[/#if]		
    ]
 
 	var data1 = [
			[#list list2 as ll]
				${ll.id1},
			[/#list]
 	]
 
	var data2 = [
			[#list list1 as l]
				  ${l.id1},
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
 
 
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#test1' 
  ,range: '~'
  
});
laydate.render({
  elem: '#test2' 
  ,range: '~'
  
});
</script>   
    
    
  </body>
</html>
