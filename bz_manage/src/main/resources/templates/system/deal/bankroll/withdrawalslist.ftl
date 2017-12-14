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
                                  	<div class="col-md-1" style="padding-right:0px">
                                   	  <select  name="type">
	                                     <option value="1" selected>店铺名称</option>
	                                     <option value="2">订单号</option>
                                      </select>
                                   	</div>
                                   	<p class="col-md-1" style="padding:0px;width:10px">:</p>
                                   	<div class="col-md-2" style="padding-left:0px">
                                     	<input type="text" name="shopname" class="form-control">   
                                    </div>
                                    <div class="col-md-1" style="padding-left:0px">
                                      <select  name="rtype">
	                                     <option value="3" selected>店铺名称</option>
	                                     <option value="4">订单号</option>
                                      </select>
                                    </div>
                                    <div class="col-md-1" style="padding:0px;width:55px">
                                    	<span>时间从：</span>
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
                                    	<span>金额从：</span>
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
                                      <th>订单号</th>
                                      <th>会员名称</th>
                                      <th>店铺名称</th>
                                      <th>提现金额</th>
                                      <th>申请时间</th>
                                      <th>审核状态</th>
                                      <th>to_id</th>
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
 	<script src="${base}/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${base}/js/bootstrap.min.js"></script>
    <script src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${base}/assets/data-tables/jquery.dataTables.js"></script>
    <script src="${base}/assets/data-tables/DT_bootstrap.js"></script>
    <script src="${base}/js/respond.min.js" ></script>
    <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>
    <script src="${base}/js/editable-table.js"></script>
      
      
    <!--this page  script only-->
    <script src="${base}/js/advanced-form-components.js"></script>

    
  </body>
</html>
