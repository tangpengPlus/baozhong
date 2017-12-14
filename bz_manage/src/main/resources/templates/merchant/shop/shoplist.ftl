<!DOCTYPE html>
<html lang="en">
  <head>
 [#include "/base/base.ftl"/]
  
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.jpg">

    <title>Gallery</title>

    <!-- Bootstrap core CSS -->
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${base}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <link href="${base}/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${base}/css/gallery.css" />

    <!-- Custom styles for this template -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <link href="${base}/css/style-responsive.css" rel="stylesheet" />
  
  
  
  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
  <style type="text/css">
  #liStyle {
  height:20px;
  width:150px;
  }
  </style>
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
              <section class="panel">
                  <header class="panel-heading">
                    [#include "/base/crumbs.ftl"/]
                  </header>
                  <div class="panel-body">
                      <ul class="grid cs-style-3" >
                      [#if merchantFile ??]
                      [#list merchantFile as ph]
                          <li id="liStyle" >
                              <figure>
                                  <img src="${ph.url}" alt="img04">
                                  <figcaption>
                                      <h3>${ph.describe}</h3>
                                      <span>${ph.name}</span>
                                      <a class="fancybox" rel="group" href="${ph.url}">大图</a>
                                  </figcaption>
                              </figure>
                          </li>
                          [/#list]
                          [/#if]
                      </ul>

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
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${base}/js/jquery.js"></script>
    <script src="${base}/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${base}/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${base}/assets/fancybox/source/jquery.fancybox.js"></script>
    <script src="${base}/js/jquery.scrollTo.min.js"></script>
    <script src="${base}/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${base}/js/respond.min.js" ></script>

    <script src="${base}/js/modernizr.custom.js"></script>
    <script src="${base}/js/toucheffects.js"></script>


    <!--common script for all pages-->
    <script src="${base}/js/common-scripts.js"></script>

  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
    
  </body>
</html>
