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
                              		<div class="col-md-1" style="padding:0px">
                              			业务员名称：
                              		</div>
                                  	<div class="col-md-2" style="padding-left:0px">
                                   		<input type="text" name="name" class="form-control">
                                   	</div>
                                   	<div class="col-md-1" style="padding:0px;width:55px">
                                   		时间从：
                                   	</div>
                                    <div class="col-md-3" style="padding-left:0px">
                                       	<div class="form-group">
                                       	     <div class="input-group input-large" data-date="2013-01-01" data-date-format="yyyy-mm-dd">
                                         		<input type="text" class="form-control dpd1"  name="start">
                                          		<span class="input-group-addon">到</span>
                                          		<input type="text" class="form-control dpd2" name="end">
                                      		 </div>
                                      	</div>
                                     </div>
                                     <div class="col-md-1" style="padding:0px;width:55px">
                                     	金额从：
                                     </div>
                                     <div class="col-md-2" style="padding-left:0px">
                                       	<div class="form-group">
                                       	      <div class="input-group input-large">
                                         		<input type="text" class="form-control"  name="mstart">
                                          		<span class="input-group-addon">到</span>
                                          		<input type="text" class="form-control" name="mend">
                                      		  </div>
                                      	</div>
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
                                  <tr>
                                      <th>微信昵称</th>
                                      <th>店铺名称</th>
                                      <th>日子内容</th>
                                      <th>金额</th>
                                      <th>订单号</th>
                                      <th>操作时间</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  [#if adminlist?? ]
	                                  [#list adminlist as admin]
	                                   <tr>
	                                      
	                                      <td class="numeric">
	                                      [@shiro.hasPermission name="/system/admin/update"]<a type="button" href="${base}/system/admin/update?id=${admin.id}" class="btn btn-danger btn-sm"><i class="icon-refresh"></i> Update</a>[/@shiro.hasPermission]
	                                      &nbsp;&nbsp;[@shiro.hasPermission name="/system/admin/delete"]<a type="button" href="${base}/system/admin/delete?id=${admin.id}" class="btn btn-warning btn-sm"><i class=" icon-trash"></i> Delete</a>[/@shiro.hasPermission]
	                                      </td>
	                                  </tr>
	                                  [/#list]
                                  [/#if]
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
