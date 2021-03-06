    [#-- 视图引用公共部分--]
    [#-- 作者:gency--]
    [#assign base = request.contextPath /]
    [#--网页头文件--]
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="${base}/img/favicon.png">
    <title>点餐猫运营平台</title>
    <!-- Bootstrap core CSS -->
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link rel="stylesheet" href="${base}/assets/bootstrap-datepicker/css/datepicker.css" />
    <link href="${base}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${base}/css/table-responsive.css" rel="stylesheet" />
    <link rel="stylesheet" href="${base}/assets/data-tables/DT_bootstrap.css" />
    <!-- Custom styles for this template -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <link href="${base}/css/style-responsive.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${base}/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
    <link rel="stylesheet" href="${base}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />
    <link rel="stylesheet" href="${base}/assets/bootstrap-timepicker/compiled/timepicker.css" />
    <link rel="stylesheet" href="${base}/assets/bootstrap-colorpicker/css/colorpicker.css" />
    <link rel="stylesheet" href="${base}/assets/bootstrap-daterangepicker/daterangepicker-bs3.css" />
    <link rel="stylesheet" href="${base}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
    <link rel="stylesheet" href="${base}/assets/jquery-multi-select/css/multi-select.css" />
    <!--分页css-->
    <link href="${base}/css/paging.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="${base}/js/html5shiv.js"></script>
      <script src="${base}/js/respond.min.js"></script>
    <![endif]-->
    <script src="${base}/js/jquery.js"></script>

   	[#--菜单导航工具--]
    [#--  作者:唐鹏                                                                                                  --]
    [#--  描述:当前ftl为动态生成系统界面的常用数据                                      --]
    [#--  版本: version 1.0.0                            --]
    [#--  时间: 2017年9月1日 上午11:42:17                   --]
    [#--  firstId:当前url地址所指一级菜单id                  --]
    [#--  secendId:当前url地址所指二级菜单id                 --]
    [#--  threeId:当前url地址所指三级菜单id                  --]
    [#--获取当前一级菜单 二级菜单三级菜单的id                    --]
    [#--springMacroRequestContext.getRequestUri():当前url--]
	 [#--初始化一级菜单id--]
	 [#assign firstId=0]
	 [#--初始化二级菜单id--]
	 [#assign secendId=0]
	 [#--初始化三级级菜单id--]
	 [#assign threeId=0]
	 [#--初始化一级菜单名称--]
	 [#assign firstMenuName=""]
	 [#--初始化二级菜单名称--]
	 [#assign secendMenuName=""]
	 [#--初始化三级菜单名称--]
	 [#assign threedMenuName=""]
	 [#--初始化一级菜地址--]
	 [#assign firstMenuUrl=""]
	 [#--初始化二级菜地址--]
	 [#assign secendMenuUrl=""]
	 [#--初始化三级菜地址--]
	 [#assign threedMenuUrl=""]
	 [#--初始化当前菜单的等级--]
	 [#assign curryPageGrade=0/]
	 [#--定义当前请求的url--]
	 [#assign currRequestRul=springMacroRequestContext.getRequestUri() /]
	 [#--定义当前菜单是否为增加或者修改菜单--]
	 [#assign isAddOrUpdatePage=0/]
	 [#--为变量赋值--]
	 [#if curryLoginAdminMenu ??]
		[#list curryLoginAdminMenu as menu]
		 	[#--当前请求菜单为一级菜单--]
		 	[#if menu.grade==1 && currRequestRul==base+menu.url]
			 	 [#--赋值一级菜单的Id--]
			 	 [#assign firstId=menu.id]
			 	 [#--赋值一级菜单的名称--]
			 	 [#assign firstMenuName=menu.name]
			 	 [#--赋值一级菜单的url--]
			 	 [#assign firstMenuUrl=menu.url]
			 	 [#break]
		 	[#--当前请求菜单为二级菜单--] 
		 	[#elseif menu.grade==2 && currRequestRul==base+menu.url]
		 	   	[#--获取当前二级菜单的上级菜单--]
		 	   	[#list curryLoginAdminMenu as menu2]
		 	   	  [#if menu.superior==menu2.id&&menu2.grade==1]
		 	   	  	 [#--获取当前一级菜单项中第一个二级菜单项--]
		 	   	  	 [#list curryLoginAdminMenu as menu5]
		 	   	  	    [#if menu5.superior==menu2.id&&menu5.grade==2]
					 	 [#--赋值一级菜单的url--]
					 	 	[#assign firstMenuUrl=menu5.url]
		 	   	  	    [#break]
		 	   	  	    [/#if]
		 	   	  	 [/#list]
		 	   	  	   	 [#--赋值一级菜单的Id--]
					 	 [#assign firstId=menu2.id]
					 	 [#--赋值一级菜单的名称--]
					 	 [#assign firstMenuName=menu2.name]
				 	 [#break]
				  [/#if]
		 	   	[/#list]
		 	   	 	 [#--赋值二级菜单的Id--]
				 	 [#assign secendId=menu.id]
				 	 [#--赋值二级菜单的名称--]
				 	 [#assign secendMenuName=menu.name]
				 	 [#--赋值二级菜单的url--]
				 	 [#assign secendMenuUrl=menu.url]
				 	 [#break]
		 	   	[#--当前请求菜单为三级菜单--]
		 	   	[#elseif menu.grade==3 && currRequestRul==base+menu.url]
		 	   	      [#--赋值三级菜单的Id--]
				 	  [#assign threeId=menu.id]
				 	  [#--赋值三级菜单的名称--]
				 	  [#assign threedMenuName=menu.name]
				 	  [#--赋值三级菜单的url--]
				 	  [#assign threedMenuUrl=menu.url]
		 	   		  [#--赋值二级菜单的信息--]
		 	   		  		[#list curryLoginAdminMenu as menu3]
					 	   	   [#if menu.superior==menu3.id&&menu3.grade==2]   
					 	   	     [#--赋值二级菜单的Id--]
							 	 [#assign secendId=menu3.id]
							 	 [#--赋值二级菜单的名称--]
							 	 [#assign secendMenuName=menu3.name]
							 	 [#--赋值二级菜单的url--]
							 	 [#assign secendMenuUrl=menu3.url]
							 	    [#--赋值一级菜单的信息--]
								  	 [#list curryLoginAdminMenu as menu4]
							 	   	  [#if menu3.superior==menu4.id&&menu4.grade==1]
							 	   	     [#list curryLoginAdminMenu as menu6]
							 	   	       [#if menu6.superior=menu4.id && menu6.grade==2]
										 	 [#--赋值一级菜单的url--]
										 	 [#assign firstMenuUrl=menu6.url]
										 	  [#break]
							 	   	       [/#if]
							 	   	     [/#list]
							 	   	         [#--赋值一级菜单的Id--]
										 	 [#assign firstId=menu4.id]
										 	 [#--赋值一级菜单的名称--]
										 	 [#assign firstMenuName=menu4.name]
									 	 [#break]
									   [/#if]
							 	   	 [/#list]
							 	 [#break]
								[/#if]
						 	 [/#list]
				 	   	 [#break] 
		 	[/#if]
		[/#list]
	 [/#if]
	[#list curryLoginAdminMenu as menu]
	[#if currRequestRul==base+menu.url]
		[#assign curryPageGrade=menu.grade/]
		[#if menu.autoattach==1]
			[#assign isAddOrUpdatePage=1/]
			[#--重写构造一二三级菜单Id--]
			[#if menu.grade==1]
			   [#list curryLoginAdminMenu as menu1]
			      [#if menu1.autoattach==0 && menu.relationmenu==menu1.id]
			      [#assign firstId=menu.id]
			      [#break]
			      [/#if]
			   [/#list]
			 [#elseif menu.grade==2]  
			 [#list curryLoginAdminMenu as menu1]
			  	  [#if menu1.autoattach==0 && menu.relationmenu==menu1.id]
			      [#assign secendId=menu1.id]
			      [#break]
			      [/#if]
			 [/#list]
			 [#elseif menu.grade==3]
			  [#list curryLoginAdminMenu as menu1]
			  	  [#if menu1.autoattach==0 && menu.relationmenu==menu1.id]
			      [#assign threeId=menu.id]
			      [#break]
			      [/#if]
			 [/#list]
			[/#if]
		[/#if]
	[#break]
	[/#if]
	[/#list]
	
	
	