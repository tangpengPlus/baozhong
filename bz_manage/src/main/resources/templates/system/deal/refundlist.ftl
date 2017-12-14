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
                              		<div class="col-md-1" style="padding:0px;width:120px">
                              			是否要求客服介入：
                              		</div>
                                    <div class="col-md-1" style="padding-left:0px">
                                       	<select  name="rtype">
	                                     <option value="3" selected>店铺名称</option>
	                                     <option value="4">订单号</option>
                                      </select>
                                     </div>
                                     <div class="col-md-1" style="padding:0px;width:100px">
                                     	申请时间排序：
                                     </div>
                                     <div class="col-md-1" style="padding-left:0px">
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
                                  <tr>
                                      <th>退款编号</th>
                                      <th>订单编号</th>
                                      <th>宝贝信息</th>
                                      <th>买家编号</th>
                                      <th>卖家</th>
                                      <th>交易金额</th>
                                      <th>退款金额</th>
                                      <th>退运费</th>
                                      <th>申请时间</th>
                                      <th>退款状态</th>
                                      <th>客服介入</th>
                                      <th>操作</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  [#if refundList?? ]
	                                  [#list refundList as refund]
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
