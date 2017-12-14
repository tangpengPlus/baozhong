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
                          [@shiro.hasPermission name="/system/admin/add"]
                              <div class="btn-group">
                                  <a id="editable-sample_new" class="btn btn-primary" href="${base}/system/admin/add">
                                                                                                                     增加商品<i class="icon-plus"></i>
                                  </a>
                              </div>
                              <div class="btn-group">
                                  <a id="editable-sample_new" class="btn btn-primary" href="${base}/system/admin/add">
                                     	 关键字列表<i class="icon-plus"></i>
                                  </a>
                              </div>
                              <div class="btn-group">
                                  <a id="editable-sample_new" class="btn btn-primary" href="${base}/system/admin/add">
                                    	 用户输入关键字 <i class="icon-plus"></i>
                                  </a>
                              </div>
                              <div class="btn-group">
                                  <a id="editable-sample_new" class="btn btn-primary" href="${base}/system/admin/add">
                                      	搜索 <i class="icon-plus"></i>
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
                                      <th>商品名</th>
                                      <th>品牌</th>
                                      <th>分类名</th>
                                      <th>店铺名</th>
                                      <th>所属城市</th>
                                      <th>商城推荐</th>
                                      <th>商城排序</th>
                                      <th>上架</th>
                                      <th>禁售</th>
                                      <th>浏览次数</th>
                                      <th>添加时间</th>
                                      <th>操作</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  [#if adminlist?? ]
	                                  [#list adminlist as admin]
	                                   <tr>
	                                   	  <td>商品名</td>
                                      	  <td>品牌</td>
                                          <td>分类名</td>
                                          <td>店铺名</td>
                                          <td>所属城市</td>
                                          <td>商城推荐</td>
                                          <td>商城排序</td>
                                          <td>上架</td>
                                          <td>禁售</td>
                                          <td>浏览次数</td>
                                          <td>[#if admin.createtime ??]${admin.createtime?datetime}[/#if]</td>
                                          <td>操作</td>
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
