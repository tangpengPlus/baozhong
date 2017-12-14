[#import "/base/spring.ftl" as spring /]
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
                                      <label class="col-sm-2 col-sm-2 control-label">等级</label>
                                      <div class="col-sm-4">
                                      <label class="col-sm-4 col-sm-4 control-label">信用介于</label>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_red_1.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:1%">—</p>
                                      <div class="col-sm-1" style="padding-left: 1%">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_red_2.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_red_3.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_red_4.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_red_5.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_blue_1.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_blue_2.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_blue_3.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_blue_4.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_blue_5.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_cap_1.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_cap_2.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_cap_3.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_cap_4.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label"><img alt="" src="${base}/img/account-grade/b_cap_5.gif"></label>
                                      <div class="col-sm-1 " style="padding-right:0px">
                                      [@spring.formInput "buyergrade.grade",'style="width:60px"' /]
                                      </div>
                                      <p class="col-sm-1" style="padding-left: 0px;width:10px">—</p>
                                      <div class="col-sm-1" style="padding-left: 5px">
                                	  [@spring.formInput "buyergrade.grade" ,'class="radiobtn" style="width:60px"'/]
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
