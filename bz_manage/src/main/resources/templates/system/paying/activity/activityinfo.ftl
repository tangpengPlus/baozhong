[#import "/base/spring.ftl" as spring /]
[#assign radioMap={"0":"否"}/]
[#assign radioMap2={"1":"是"}/]

<!DOCTYPE html>
<html lang="en">
  <head>
    [#include "/base/base.ftl"/]
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
                                      <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">所属频道</label>
                                      <div class="col-lg-4">
                                          <select class="form-control m-bot15" name="menuid">
                                          [#if menulist ??]
                                            [#list menulist as menu]
                                            	[#if menu.type==1&&menu.autoattach==0]
                                            		[#if manageAuthority.menuid==menu.id]
                                            			<option value="${menu.id}" selected="selected">${menu.name}</option>
                                            		[#else]
                                            			<option value="${menu.id}">${menu.name}</option>
                                            		[/#if]
                                            	
                                            	[/#if]
                                            [/#list]
                                          [/#if]
                                          </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">活动名称</label>
                                      <div class="col-sm-4">
                                        <input type="text">
                                      </div>
                                       <div class="col-sm-4 messageTip">
                                   		    <span>活动名称100个字符以内</span>
                                            [@spring.showErrors /]
                                      </div>
                                  </div>
                                  <div class="form-group">
            						<label class="control-label col-md-3">开始时间</label>
            							<div class="col-md-4">
                							<div data-date="2012-12-21T15:25:00Z" class="input-group date form_datetime-adv">
                    						<input type="text" class="form-control" readonly="" size="16">
                   	 							<div class="input-group-btn">
                        							<button type="button" class="btn btn-danger date-reset"><i class="icon-remove"></i></button>
                        							<button type="button" class="btn btn-warning date-set"><i class="icon-calendar"></i></button>
                    							</div>
                							</div>
            						</div>
        						  </div>
                                  <div class="form-group">
            						<label class="control-label col-md-3">开始时间</label>
            							<div class="col-md-4">
                							<div data-date="2012-12-21T15:25:00Z" class="input-group date form_datetime-adv">
                    						<input type="text" class="form-control" readonly="" size="16">
                   	 							<div class="input-group-btn">
                        							<button type="button" class="btn btn-danger date-reset"><i class="icon-remove"></i></button>
                        							<button type="button" class="btn btn-warning date-set"><i class="icon-calendar"></i></button>
                    							</div>
                							</div>
            						</div>
        						  </div>
                                  <div class="form-group">
            						<label class="control-label col-md-3">开始时间</label>
            							<div class="col-md-4">
                							<div data-date="2012-12-21T15:25:00Z" class="input-group date form_datetime-adv">
                    						<input type="text" class="form-control" readonly="" size="16">
                   	 							<div class="input-group-btn">
                        							<button type="button" class="btn btn-danger date-reset"><i class="icon-remove"></i></button>
                        							<button type="button" class="btn btn-warning date-set"><i class="icon-calendar"></i></button>
                    							</div>
                							</div>
            						</div>
        						  </div>
                                  
                                   <div class="form-group">
                                      <div class="col-lg-offset-2 col-lg-10">
                                          <button class="btn btn-danger" type="submit">Submit</button>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-lg-offset-2 col-lg-10">
                                          <button class="btn btn-danger" type="reset">Reset</button>
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
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="${base}/js/respond.min.js" ></script>
    <script src="${base}/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script class="include" type="text/javascript" src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>

  <!--custom switch-->
  <script src="${base}/js/bootstrap-switch.js"></script>
  <!--custom tagsinput-->
  <script src="${base}/js/jquery.tagsinput.js"></script>
  <!--custom checkbox & radio-->
  <script type="text/javascript" src="${base}/js/ga.js"></script>

  <!--this page plugins-->
  <script type="text/javascript" src="${base}/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-daterangepicker/date.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
  <script type="text/javascript" src="${base}/assets/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
  <script type="text/javascript" src="${base}/assets/fuelux/js/spinner.min.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="${base}/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
  <script type="text/javascript" src="${base}/assets/jquery-multi-select/js/jquery.multi-select.js"></script>
  <script type="text/javascript" src="${base}/assets/jquery-multi-select/js/jquery.quicksearch.js"></script>

  <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>

  <!--script for this page-->
  <script src="${base}/js/form-component.js"></script>

  </body>
</html>
