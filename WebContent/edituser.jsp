<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >

<head>
    <base href="<%=basePath%>">
    <title>添加课程</title>
    
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <!-- Bootstrap Styles-->
    <link href="css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="css/font-awesome.css" rel="stylesheet" />   
    <link href="css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
  </head>
  

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">中矿大选课系统</a>
            </div>

                                <!-- /.顶部 -->
            
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                </li>
                
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    </li>
                
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                </li>
                
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 个人用户</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 登录</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        
        
        <!--目录  -->
       
       
       
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                 <ul class="nav" id="main-menu">

                    <li>
                        <a href="index.html"><i class="fa fa-dashboard"></i> 首页</a>
                    </li>
                    <li>
                        <a href="search.jsp"><i class="fa fa-desktop"></i> 所有课程</a>
                    </li>
                     
                <li class="">
                        <a href="#"><i class="fa fa-sitemap"></i> 我的课程<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level collapse" style="height: 0px;">
                            <li>
                                <a href="#">已选课程</a>
                            </li>
                            <li>
                                <a href="edituser.jsp">添加课程</a>
                            </li>
                           
                        </ul>
                    </li>
                   <li>
                        <a href="search.jsp"><i class="fa fa-table"></i> 选课情况</a>
                    </li>
                   
                </ul>

            </div>

        </nav>
       
       
       
       
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            选课系统<small>添加课程</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
              <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            课程详情
                        </div>
                        <div class="panel-body">
                            <div class="row">
                             
                            
                                <!-- /.col-lg-6 (nested) -->
                                
                       <h2> <c:if test="${type=='add'}"> 添加学生</c:if> <c:if test="${type=='edit'}">  修改学生</c:if> </h2>
                              
                                <div class="col-lg-6">
                                    <form  action="student?action=${type}" method="post">
                                   
                                    <div class="form-group input-group">
                                            <span class="input-group-addon">①</span>
                                 <c:if test="${ empty student }"> <input class="form-control" placeholder="ID" type="text" name="sid"></c:if>
                                 <c:if test="${ !empty student }"> <input type="hidden" name="sid" value="${student.sid}">${student.sid} </c:if>  
                                            
                                        </div>
                                      <div class="form-group input-group">
                                            <span class="input-group-addon">②</span>
                             <input type="text" name="sname" class="form-control" placeholder="编号" <c:if test="${!empty student }"> value="${student.sname}" </c:if> >
                                        </div>
                                          <div class="form-group input-group">
                                            <span class="input-group-addon">③</span>
                             <input type="text" name="sage" class="form-control" placeholder="任课教师" <c:if test="${!empty student }"> value="${student.sage}" </c:if>>
                                        </div>
                                          <div class="form-group input-group">
                                            <span class="input-group-addon">④</span>
                                            <input type="text" class="form-control" placeholder="上课时间">
                                        </div>
                                         <div class="form-group input-group">
                                            <span class="input-group-addon">⑤</span>
                                            <input type="text" class="form-control" placeholder="教室">
                                        </div>
                                     
                                       
                                       
                                        <button type="submit" class="btn btn-default">提交</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </form>
                                </div>
                               
                              
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<footer><p>Copyright &copy; 2016.</p></footer>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
