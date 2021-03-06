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
                          [@shiro.hasPermission name="/system/authority/add"]
                              <div class="btn-group">
                                  <a id="editable-sample_new" class="btn btn-primary" href="${base}/system/shopset/addgrade">
                                      Add New <i class="icon-plus"></i>
                                  </a>
                              </div>
                          [/@shiro.hasPermission]
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
                                      <th>商铺等级名称</th>
                                      <th>允许发布商品数</th>
                                      <th class="numeric">上传空间大小(MB)</th>
                                      <th class="numeric">可选模板套数</th>
                                      <th class="numeric">收费标准</th>
                                      <th class="numeric">需要审核</th>
                                      <th class="numeric">操作</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  [#if shopgrade?? ]
	                                  [#list shopgrade as sg]
	                                   <tr>
	                                      <td>${sg.gradeName}</td>
	                                      <td class="numeric">${sg.allowAmount}</td>
	                                      <td class="numeric">${sg.uploadSize}</td>
	                                      <td class="numeric">${sg.modelAmount}</td>
	                                      <td class="numeric">${sg.chargeStandard}</td>
	                                      <td class="numeric">${sg.isAudit}</td>
	                                      <td class="numeric">
	                                      [@shiro.hasPermission name="/system/authority/update"]<a type="button" href="${base}/system/shopset/updategrade?id=${sg.id}" class="btn btn-danger btn-sm"><i class="icon-refresh"></i> Update</a>[/@shiro.hasPermission]
	                                      &nbsp;&nbsp;[@shiro.hasPermission name="/system/authority/delete"]<a type="button" href="${base}/system/shopset/deletegrade?id=${sg.id}" class="btn btn-warning btn-sm"><i class=" icon-trash"></i> Delete</a>[/@shiro.hasPermission]
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