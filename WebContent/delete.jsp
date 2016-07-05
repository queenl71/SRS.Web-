<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE >
<html >

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>吉他销售系统</title>
   <!-- Bootstrap Styles-->
    <link href="css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
        <!-- Custom Styles-->
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
                        <a href="search.jsp" ><i class="fa fa-desktop"></i> 所有课程</a>
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
                        <a href="delete.jsp"class="active-menu"><i class="fa fa-table"></i> 选课情况</a>
                    </li>
                   
                </ul>

            </div>

        </nav>
       
       
       
       
       
        <!-- 右侧  -->
       <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                       <h1 class="page-header">
                            选课系统<small>所有课程</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
选课操作                      </div>
                        
                       
                       
                        <form action="searchCourse" method="post">
  
   <label>课程id：</label>        <select name="model" id="model" >
                                            <option></option>
                                            <option >1</option>
                                            <option>2</option>
	                                        <option>3</option>
                                      </select>



       
        <input type="submit" name="find" id="find"  value="查询">

    </form>
    
    <div class="panel-body">
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                              添加课程
                            </button>
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">课程删除成功</h4>
                                        </div>
                                       
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
    
                        <div class="panel-body">
                            <div class="table-responsive">
          <table class="table table-striped table-bordered " id="">
                                   <thead>
	        <tr>
	            <th>ID</th>
	            <th>编号</th>
	            <th>教师</th>
	            <th>上课时间</th>
	            <th>教室</th>
	  	          <th>操作</th>
	            
	           
	        </tr>
	    </thead>
	    
	  
	    
      <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>数学</td>
                                            <td>jds</td>
                                            <td>11</td>
                                            <td>11</td>
                                            <td><button type="submit" >删除</button><button type="submit" >修改</button></td>
                                            
                                            
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>数学</td>
                                            <td>demw</td>
                                            <td>22</td>
                                             <td>22</td>
                                            <td><button type="submit" >删除</button><button type="submit" >修改</button></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>英语</td>
                                            <td>thej</td>
                                            <td>33</td>
                                             <td>33</td>
                                            <td><button type="submit" >删除</button><button type="submit" >修改</button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                        
                       
                   <!-- /东大  -->
                        
  
  
                        
                        
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
            
                
           
         
                <!-- /. ROW  -->
        </div>
               <footer><p>Copyright &copy; 2016.</p></footer>
    </div>
        
    </div>
   
   
    <!-- jQuery Js -->
    <script src="js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
        
        
         <!-- Custom Js -->
    



</body>

</html>