[#import "/base/spring.ftl" as spring /]
[#assign radioMap={"0":"开启"}/]
[#assign radioMap2={"1":"关闭"}/]
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
                                      <label class="col-sm-2 col-sm-2 control-label">商城名称</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.name",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">标题</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.title",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
                                    <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">网站描述</label>
                                      <div class="col-sm-4">
                                      [@spring.formTextarea "information.description",'class="form-control" rows="5"'/]
                                  	  </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">网站关键字</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.keyword",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">版权信息</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.copyright",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">copyright_url</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.copyrightUrl",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
								  <!--Advanced File Input start-->
              <div class="row">
                  <div class="col-md-8">
                      <section class="panel">
                          
                         
                                      <div class="form-group last">
                                          <label class="control-label col-md-3">网站log</label>
                                          <div class="col-md-4">
                                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                                  <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                      <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image" alt="" />
                                                  </div>
                                                  <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                                  <div>
                                                   <span class="btn btn-white btn-file">
                                                   <span class="fileupload-new"><i class="icon-paper-clip"></i> 选择图片</span>
                                                   <span class="fileupload-exists"><i class="icon-undo"></i> Change</span>
                                                   <input type="file" class="default" />
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

                            
                       
                                					
                      </section>
                  </div>
              </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">ICP证书号</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.icp",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">网站所在地</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.location",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">网站详细地址</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.address",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">邮编</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.postcode",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">电话</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.phone",'class="form-control"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Email</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.email",'class="form-control"'/]
                                      </div>
                                  </div>

                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">网站状态</label>
                                       <div class="col-sm-4 text-center">
                                        [@spring.formRadioButtons "information.isdelete" ,radioMap,'','checked="checked"'/]
                                		[@spring.formRadioButtons "information.isdelete" ,radioMap2,'','class="radiobtn"'/]
                                       </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">关闭原因</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.reason",'class="form-control"'/]
                                      </div>
                                  </div>
                                  	
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">热门搜索</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.search",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">百度AK密钥</label>
                                      <div class="col-sm-4">
                                      [@spring.formInput "information.baiduKey",'class="form-control"'/]
                                      </div>
                                  </div>
                                  
                                   <div class="form-group">
                                      <div class="col-lg-offset-2 col-lg-10">
                                          <button class="btn btn-danger" type="submit">提交</button>
                                          <button class="btn btn-danger" type="reset">重置</button>
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
