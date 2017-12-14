<!DOCTYPE html>
<html lang="en">
  <head>
 [#include "/base/base.ftl"/]
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
                          <div class="clearfix">
                              <form method="post"  >
                          	   		<div class="col-md-1" style="padding:0px;width:100px">
                                   		买家用户编号：
                                   	</div>
                                   	<div class="col-md-2" style="padding-left:0px">
                                     	<input type="text" name="shopname" class="form-control">   
                                    </div>
                                    <div class="col-md-1" style="padding:0px;width:100px">
                                   		卖家店铺名称：
                                   	</div>
                                   	<div class="col-md-2" style="padding-left:0px">
                                     	<input type="text" name="shopname" class="form-control">   
                                    </div>
                          	   		<div class="col-md-1" style="padding:0px;width:45px">
                                   		评价：
                                   	</div>
                                  	<div class="col-md-1" style="padding:0px">
                                   	  <select  name="type">
	                                     <option value="1" selected>店铺名称</option>
	                                     <option value="2">订单号</option>
                                      </select>
                                   	</div>
                                    <div class="col-md-1" style="padding:0px;width:45px">
                                   		内容：
                                   	</div>
                                    <div class="col-md-1" style="padding:0px">
                                      <select  name="rtype">
	                                     <option value="3" selected>店铺名称</option>
	                                     <option value="4">订单号</option>
                                      </select>
                                    </div>
                              	     <div class="col-md-1" style="padding-left:0px">
                              	     	<input type="submit" value="查询">
                              	     </div>
                              	</form>
                              <div class="btn-group pull-right">
                                  <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
                                  </button>
                                  <ul class="dropdown-menu pull-right">
                                      <li><a href="#">Print</a></li>
                                      <li><a href="#">Save as PDF</a></li>
                                      <li><a href="#">Export to Excel</a></li>
                                  </ul>
                              </div>
                          </div>
                          <div class="space15"></div>
                           <div class="panel-body">
                              <section id="no-more-tables">
                                <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  
                                  </thead>
                                  <tbody>
                                  
                              </tbody>
                              </table>
                              [#include "/base/page.ftl"/]
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
 	<script src="${base}/js/jquery-1.8.3.min.js"></script>
    <script src="${base}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script type="text/javascript" src="${base}/assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="${base}/assets/data-tables/DT_bootstrap.js"></script>
    <script src="${base}/js/respond.min.js" ></script>
    <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>
      <script src="${base}/js/editable-table.js"></script>
  </body>
</html>
