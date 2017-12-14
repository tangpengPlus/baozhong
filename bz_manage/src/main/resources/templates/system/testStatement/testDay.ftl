<!DOCTYPE html>
<html lang="en">
  <head>
 [#include "/base/base.ftl"/]
 
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
            <div class="rep_item">
                <div class="rep_input_Box">
                    <input type="text" class="laydate-icon times" name="date" id="start04" placeholder="选择日期" value="${date}"/>
                    <button class="timeBtn">确定</button>
                </div>
                <!--销售收入-->
                <div class="rep_item_income">
                    <div class="rep_tit">销售收入</div>
                    <div class="income_l"><p>&yen;0.00</p></div>
                    <div class="income_2">
                    
                        <p>昨日：<span>&yen;0.00</span></p>
                        <p>环比：<span>%0</span></p>
                        <p>去年同期：<span>&yen;0.00</span></p>
                        <p>同比：<span>%0</span></p>
                    </div>
                    <!--销售收入折线图-->
                    <div class="income_3">
                        <div id="income_main"></div>
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
 	 
    
   <script>
// TODO 销售收入-柱状图
   function myChart01Fun(){
   //销售收入
   var myChart01 = echarts.init(document.getElementById('income_main'));
   var salesVals= [];
   salesVals[2] = parseFloat($('.income_l').find('p').text().split('¥').join("").split(',').join(""));
   salesVals[1] = parseFloat($($('.income_2').find('p')[0]).find('span').text().split('¥').join("").split(',').join(""));
   salesVals[0] = parseFloat($($('.income_2').find('p')[2]).find('span').text().split('¥').join("").split(',').join(""));

	times_value = $('.times').val(); //输入框内的日期值\
   var	day_number = [
           (parseInt(times_value.substring(0,4))-1)+'年同期',
           daysDateFun(1).toString().substring(5),
           daysDateFun(0).toString().substring(5)
       ];
	
   // 指定图表的配置项和数据
   option01 =  {
       valueAxis:2000,
       tooltip : {
           formatter: "{b} <br/>{a}:￥{c}",
           trigger: 'item'
       },
       xAxis : [
           {
               data : day_number
           }
       ],
       yAxis : [
           {
               type : 'value'
           }
       ],
       grid:[
           {
               x:80
           }
       ],
       series : [
           {
               itemStyle: {
                   normal: {
                       color: function(params) {
                           // build a color map as your need.
                           var colorList = [
                               '#FFCC00','#009999','#CC3333'
                           ];
                           return colorList[params.dataIndex]
                       },
                       label: {
                           show: true,
                           position: 'top',
                           formatter: function (params,ticket,callback) {
                               return '￥'+ fmoney(params.value,2);

                           }
                       }
                   }
               },
               name:'营业额',
               type:'bar',
               barCategoryGap: '70%',
               data:salesVals
           }
       ]
   };
   
   // 使用刚指定的配置项和数据显示图表。
   myChart01.setOption(option01);
};
	</script>
  </body>
</html>