[#import "/base/spring.ftl" as spring /]
[#assign radioMap={"0":"正常"}/]
[#assign radioMap2={"1":"冻结"}/]
<!DOCTYPE html>
<html lang="en">
  <head>
    [#include "/base/base.ftl"/]
    <link rel="stylesheet" type="text/css" href="${base}/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
  </head>

  <body>

  <section id="container" class="">
      <!--header start-->
      [#include "/base/header.ftl"/]
      <!--header end-->
      <!--sidebar start-->
       [#include "/base/left.ftl"/]
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          [#include "/base/crumbs.ftl"/]
                          <div class="panel-body">
                              <form class="form-horizontal tasi-form" method="post">
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">居家商品图片名称</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "houseAndHome.name",'class="form-control"'/]
                                      </div>
                                       <div class="col-sm-4 messageTip">
                                   		   <!-- <span>素材min必须是字母、数字、下划线、横杠组成的最小6位最多12位的字符！</span>-->
                                            [@spring.showErrors /]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">居家商品图片存放地址</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "houseAndHome.url",'class="form-control"'/]
                                      </div>
                                       <div class="col-sm-4 messageTip">
                                            [@spring.showErrors /]
                                      </div>
                                  </div>
                                  
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">居家商品显示地址</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "houseAndHome.place",'class="form-control"'/]
                                      </div>
                                       <div class="col-sm-4 messageTip">
                                            [@spring.showErrors /]
                                      </div>	
                                  </div>
                                  
                                  
                                 <div class="form-group last">
                                          <label class="control-label col-md-3">居家商品图片上传</label>
                                          <div>
                                          
                                          </div>
                                          <div class="col-md-9" id="phoneset.logo">
                                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                                  <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                      <img src="${houseAndHome.picture}" alt="" />
                                                  </div>
                                                  <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;">
												  </div>
                                                  <div>
                                                   <span class="btn btn-white btn-file">
                                                   <span class="fileupload-new"><i class="icon-paper-clip"></i> Select image</span>
                                                   <span class="fileupload-exists"><i class="icon-undo"></i> Change</span>
                                                   <input type="file" class="default"/>
                                                   </span>
                                                      <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="icon-trash"></i> Remove</a>
                                                  </div>
                                              </div>
                                              <span class="label label-danger">NOTE!</span>
                                             <span>
                                             Attached image thumbnail is
                                             supported in Latest Firefox, Chrome, Opera,
                                             Safari and Internet Explorer 10 only
                                             </span>
                                          </div>
                                      </div>
                                  
                                   [@spring.formInput "houseAndHome.id", "", "hidden"/]
                                      
                                   <div class="form-group">
                                      <div class="col-lg-offset-2 col-lg-10">
                                          <button class="btn btn-danger" type="submit">提交</button>
                                      </div>
                                  </div>
                                  
                              </form>
                          </div>
                      </section>
                  </div>
              </div>
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
    <script src="${base}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${base}/js/respond.min.js" ></script>
  
    <!--this page plugins-->

  <script type="text/javascript" src="${base}/assets/fuelux/js/spinner.min.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/jquery-multi-select/js/jquery.multi-select.js"></script>
  <script type="text/javascript" src="${base}/assets/jquery-multi-select/js/jquery.quicksearch.js"></script>
 <!--common script for all pages-->
 <script src="${base}/js/common-scripts.js"></script>
 <!--this page  script only-->
 <script src="${base}/js/advanced-form-components.js"></script>

  </body>
</html>
