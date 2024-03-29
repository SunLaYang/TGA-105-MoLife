<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>MoLife 後台</title>

    <!-- Google Font: Source Sans Pro -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
    />
    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/fontawesome-free/css/all.min.css"
    />
    <!-- Ionicons -->
    <link
      rel="stylesheet"
      href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
    />
    <!-- Tempusdominus Bootstrap 4 -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"
    />
    <!-- iCheck -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/icheck-bootstrap/icheck-bootstrap.min.css"
    />
    <!-- JQVMap -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/jqvmap/jqvmap.min.css"
    />
    <!-- Theme style -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/dist/css/adminlte.min.css"
    />
    <!-- overlayScrollbars -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"
    />
    <!-- Daterange picker -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/daterangepicker/daterangepicker.css"
    />
    <!-- summernote -->
    <link
      rel="stylesheet"
      href="../../AdminLTE-3.2.0/plugins/summernote/summernote-bs4.min.css"
    />

    <script
      src="https://kit.fontawesome.com/2672c0b72c.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
      <!-- Preloader -->
      <div
        class="preloader flex-column justify-content-center align-items-center"
      >
        <img
          class="animation__shake"
          src="../../AdminLTE-3.2.0/dist/img/AdminLTELogo.png"
          alt="AdminLTELogo"
          height="60"
          width="60"
        />
      </div>

      <!-- Navbar -->
      <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"
              ><i class="fas fa-bars"></i
            ></a>
          </li>
          <li class="nav-item d-none d-sm-inline-block">
            <a href="<%=request.getContextPath()%>/page/others/24admin.index.html" class="nav-link">首頁</a>
          </li>
          <!-- <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li> -->
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
          <!-- Navbar Search -->
          <li class="nav-item">
            <a
              class="nav-link"
              data-widget="navbar-search"
              href="#"
              role="button"
            >
              <i class="fas fa-search"></i>
            </a>
            <div class="navbar-search-block">
              <form class="form-inline">
                <div class="input-group input-group-sm">
                  <input
                    class="form-control form-control-navbar"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                  />
                  <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                      <i class="fas fa-search"></i>
                    </button>
                    <button
                      class="btn btn-navbar"
                      type="button"
                      data-widget="navbar-search"
                    >
                      <i class="fas fa-times"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </li>

          <!-- Messages Dropdown Menu -->
          <!-- <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item"> -->
          <!-- Message Start -->
          <!-- <div class="media">
              <img src="../../AdminLTE-3.2.0/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div> -->
          <!-- Message End -->
          <!-- </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item"> -->
          <!-- Message Start -->
          <!-- <div class="media">
              <img src="../../AdminLTE-3.2.0/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div> -->
          <!-- Message End -->
          <!-- </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item"> -->
          <!-- Message Start -->
          <!-- <div class="media">
              <img src="../../AdminLTE-3.2.0/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div> -->
          <!-- Message End -->
          <!-- </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li> -->
          <!-- Notifications Dropdown Menu -->
          <!-- <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-controlsidebar-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li> -->
        </ul>
      </nav>
      <!-- /.navbar -->

      <!-- Main Sidebar Container -->
      <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="<%=request.getContextPath()%>/page/others/24admin.index.html" class="brand-link">
          <img
            src="../../AdminLTE-3.2.0/dist/img/AdminLTELogo.png"
            alt="AdminLTE Logo"
            class="brand-image img-circle elevation-3"
            style="opacity: 0.8"
          />
          <span class="brand-text font-weight-light" style="padding-left: 20px"
            >MoLife<i class="fa-solid fa-paw" style="padding-left: 20px"></i
          ></span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
              <img
                src="../../css/donate/donate_pic/ru.jpg"
                class="img-circle elevation-2"
                alt="User Image"
              />
            </div>
            <div class="info">
              <a href="#" class="d-block">Nicole Chu</a>
            </div>
          </div>

          <!-- SidebarSearch Form -->
          <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
              <input
                class="form-control form-control-sidebar"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <div class="input-group-append">
                <button class="btn btn-sidebar">
                  <i class="fas fa-search fa-fw"></i>
                </button>
              </div>
            </div>
          </div>

          <!-- Sidebar Menu -->
          <nav class="mt-2">
            <ul
              class="nav nav-pills nav-sidebar flex-column"
              data-widget="treeview"
              role="menu"
              data-accordion="false"
            >
              <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
              <li class="nav-item menu-open">
                <a href="<%=request.getContextPath()%>" class="nav-link active">
                  <i class="nav-icon fas fa-tachometer-alt"></i>
                  <p>
                    用戶管理
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/pages/admin/listOneEmp.jsp" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>帳戶管理</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/pages/member/listAllMem.jsp" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>會員管理</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/pages/admin/listAllEmp.jsp" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>權限管理</p>
                    </a>
                  </li>
                </ul>
              </li>

              <li class="nav-item">
                <a href="" class="nav-link">
                  <i class="nav-icon fas fa-copy"></i>
                  <p>
                    商城後台管理
                    <i class="fas fa-angle-left right"></i>
                    <span class="badge badge-info right">6</span>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/page/shop/admin.productlist.html" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>商品管理</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/page/shop/admin.productorder.html" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>訂單管理</p>
                    </a>
                  </li>
                  <!-- <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/boxed.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Boxed</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/fixed-sidebar.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Fixed Sidebar</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/fixed-sidebar-custom.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Fixed Sidebar <small>+ Custom Area</small></p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/fixed-topnav.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Fixed Navbar</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/fixed-footer.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Fixed Footer</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/layout/collapsed-sidebar.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Collapsed Sidebar</p>
                </a>
              </li> -->
                </ul>
              </li>

              <li class="nav-item">
                <a href="<%=request.getContextPath()%>" class="nav-link">
                  <i class="nav-icon fas fa-chart-pie"></i>
                  <p>
                    旅館後台管理
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/page/room/01Roommanage.admin.html" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>房型管理</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/page/room/01RoomOrder.admin.html" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>訂單管理</p>
                    </a>
                  </li>
                  <!-- <li class="nav-item">
                <a href="../../AdminLTE-3.2.0/pages/charts/uplot.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>uPlot</p>
                </a>
              </li> -->
                </ul>
              </li>

              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/page/others/24admin.news.html" class="nav-link">
                  <i class="nav-icon fas fa-th"></i>
                  <p>
                    前台頁面管理
                    <span class="right badge badge-danger">New</span>
                  </p>
                </a>
              </li>

              <li class="nav-item">
                <a href="" class="nav-link">
                  <i class="nav-icon fas fa-tree"></i>
                  <p>
                    募款後台管理
                    <i class="fas fa-angle-left right"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/pages/donate/donatePlanAdmin" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>提案募款紀錄</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="<%=request.getContextPath()%>/pages/donate/donatePaymentAdmin" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>捐款紀錄查詢</p>
                    </a>
                  </li>
                  <!-- <li class="nav-item">
                    <a href="..." class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>Buttons</p>
                    </a>
                  </li> -->
                  <!-- <li class="nav-item">
                <a href="..." class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Sliders</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="..." class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Modals & Alerts</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="..." class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Navbar & Tabs</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="..." class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Timeline</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="..." class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Ribbons</p>
                </a>
              </li> -->
                </ul>
              </li>

              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/page/others/24admin.forum.html" class="nav-link">
                  <i class="nav-icon fas fa-edit"></i>
                  <p>
                    論壇後台管理
                    <i class="fas fa-angle-left right"></i>
                  </p>
                </a>
              </li>

              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/page/others/24admin.chatroom.html" class="nav-link">
                  <i class="nav-icon fas fa-table"></i>
                  <p>
                    聊天室管理
                    <span class="right badge badge-danger">New</span>
                  </p>
                </a>
              </li>
            </ul>
          </nav>
          <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h1 class="m-0">
                  <i class="fa-solid fa-paw" style="padding-right: 20px"></i>
                  後台管理員介面
                </h1>
              </div>
              <!-- /.col -->
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item">
                    <a href="<%=request.getContextPath()%>/page/others/24admin.index.html">首頁</a>
                  </li>
                  <!-- <li class="breadcrumb-item active">Dashboard v1</li> -->
                </ol>
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
          <!-- Default box -->
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">捐款紀錄查詢</h3>
  
              <div class="card-tools">
                <div class="card-tools">
                  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pages/donate/AdminServlet" >
                  	<label style="font-weight: normal;">選擇計畫進度</label>
                  	<select class="select2" name="planStatusId" style="width: 60%;">
                      <option selected>請選擇</option>
                      <option value="3">募款中</option>
                      <option value="4">已結案</option>
                   	</select>
                   	<input type="hidden" name="adminAction" value="selectByPay">
                    <input type="submit" value="查詢" class="btn btn-outline-dark">
                  </FORM>
                </div>
              </div>
            </div>
  
            <div class="card-body p-0" >
              <table class="table table-striped projects">
                <thead style="text-align: center;">
                  <tr>
                    <th style="width: 10%">捐款時間戳</th>
                    <th style="width: 10%">募款計畫名稱</th>
                    <th style="width: 10%">計畫編號</th>
                    <th style="width: 10%">計畫進度</th>
                    <th style="width: 10%">捐款會員編號</th>
                    <th style="width: 10%">捐款編號</th>
                    <th style="width: 10%">捐款金額</th>
                  </tr>
                </thead>
  
                <tbody style="text-align: center;">
                <c:forEach var="payVO" items="${payList}">
                  <tr>
                 	<td>${payVO.paymentDate}</td>
                 	<td>${payVO.planVO.planName}</td>
                    <td>${payVO.planId}</td>
                    <td>${payVO.planStatusVO.planStatus}</td>
                    <td>${payVO.memeberId}</td>
                    <td>${payVO.paymentId}</td>
                    <td>${payVO.paymentAmount}</td>
                  </tr>
                 </c:forEach>
                 <!--    <td>${payVO.planVO.planName}</td>
                    <td>${payVO.planVO.planId}</td>
                    <td>${payVO.planStatusVO.planStatus}</td> -->
                  <!-- ---------------------------- -->
                  
                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
  
        </section>
        <!-- /.content -->
        
      </div>
      <!-- /.content-wrapper -->

      </div>
      <!-- /.content-wrapper -->

<br>
<br>

      <footer class="main-footer">
        <strong
          >MoLife <i class="fa-solid fa-paw"></i> &copy; 2022
          <a href="https://adminlte.io">TGA105-第四組</a>.</strong
        >
        All rights reserved.
        <div class="float-right d-none d-sm-inline-block">
          <b>Version</b> 3.2.0
        </div>
      </footer>

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
      </aside>
      <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="../../AdminLTE-3.2.0/plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="../../AdminLTE-3.2.0/plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge("uibutton", $.ui.button);
    </script>
    <!-- Bootstrap 4 -->
    <script src="../../AdminLTE-3.2.0/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- ChartJS -->
    <script src="../../AdminLTE-3.2.0/plugins/chart.js/Chart.min.js"></script>
    <!-- Sparkline -->
    <script src="../../AdminLTE-3.2.0/plugins/sparklines/sparkline.js"></script>
    <!-- JQVMap -->
    <script src="../../AdminLTE-3.2.0/plugins/jqvmap/jquery.vmap.min.js"></script>
    <script src="../../AdminLTE-3.2.0/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="../../AdminLTE-3.2.0/plugins/jquery-knob/jquery.knob.min.js"></script>
    <!-- daterangepicker -->
    <script src="../../AdminLTE-3.2.0/plugins/moment/moment.min.js"></script>
    <script src="../../AdminLTE-3.2.0/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- Tempusdominus Bootstrap 4 -->
    <script src="../../AdminLTE-3.2.0/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
    <!-- Summernote -->
    <script src="../../AdminLTE-3.2.0/plugins/summernote/summernote-bs4.min.js"></script>
    <!-- overlayScrollbars -->
    <script src="../../AdminLTE-3.2.0/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../../AdminLTE-3.2.0/dist/js/adminlte.js"></script>
    <!-- AdminLTE for demo purposes -->
    <!-- <script src="../../AdminLTE-3.2.0/dist/js/demo.js"></script> -->
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <!-- <script src="../../AdminLTE-3.2.0/dist/js/pages/dashboard.js"></script> -->

    <!-- Page specific script -->
    <script>
      $(function () {
        /* ChartJS
         * -------
         * Here we will create a few charts using ChartJS
         */

        //--------------
        //- AREA CHART -
        //--------------

        // Get context with jQuery - using jQuery's .get() method.
        var areaChartCanvas = $("#areaChart").get(0).getContext("2d");

        var areaChartData = {
          labels: [
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
          ],
          datasets: [
            {
              label: "Digital Goods",
              backgroundColor: "rgba(60,141,188,0.9)",
              borderColor: "rgba(60,141,188,0.8)",
              pointRadius: false,
              pointColor: "#3b8bba",
              pointStrokeColor: "rgba(60,141,188,1)",
              pointHighlightFill: "#fff",
              pointHighlightStroke: "rgba(60,141,188,1)",
              data: [28, 48, 40, 19, 86, 27, 90],
            },
            {
              label: "Electronics",
              backgroundColor: "rgba(210, 214, 222, 1)",
              borderColor: "rgba(210, 214, 222, 1)",
              pointRadius: false,
              pointColor: "rgba(210, 214, 222, 1)",
              pointStrokeColor: "#c1c7d1",
              pointHighlightFill: "#fff",
              pointHighlightStroke: "rgba(220,220,220,1)",
              data: [65, 59, 80, 81, 56, 55, 40],
            },
          ],
        };

        var areaChartOptions = {
          maintainAspectRatio: false,
          responsive: true,
          legend: {
            display: false,
          },
          scales: {
            xAxes: [
              {
                gridLines: {
                  display: false,
                },
              },
            ],
            yAxes: [
              {
                gridLines: {
                  display: false,
                },
              },
            ],
          },
        };

        // This will get the first returned node in the jQuery collection.
        new Chart(areaChartCanvas, {
          type: "line",
          data: areaChartData,
          options: areaChartOptions,
        });

        //-------------
        //- LINE CHART -
        //--------------
        var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
        var lineChartOptions = $.extend(true, {}, areaChartOptions);
        var lineChartData = $.extend(true, {}, areaChartData);
        lineChartData.datasets[0].fill = false;
        lineChartData.datasets[1].fill = false;
        lineChartOptions.datasetFill = false;

        var lineChart = new Chart(lineChartCanvas, {
          type: "line",
          data: lineChartData,
          options: lineChartOptions,
        });

        //-------------
        //- DONUT CHART -
        //-------------
        // Get context with jQuery - using jQuery's .get() method.
        var donutChartCanvas = $("#donutChart").get(0).getContext("2d");
        var donutData = {
          labels: ["Chrome", "IE", "FireFox", "Safari", "Opera", "Navigator"],
          datasets: [
            {
              data: [700, 500, 400, 600, 300, 100],
              backgroundColor: [
                "#f56954",
                "#00a65a",
                "#f39c12",
                "#00c0ef",
                "#3c8dbc",
                "#d2d6de",
              ],
            },
          ],
        };
        var donutOptions = {
          maintainAspectRatio: false,
          responsive: true,
        };
        //Create pie or douhnut chart
        // You can switch between pie and douhnut using the method below.
        new Chart(donutChartCanvas, {
          type: "doughnut",
          data: donutData,
          options: donutOptions,
        });

        //   //-------------
        //   //- PIE CHART -
        //   //-------------
        //   // Get context with jQuery - using jQuery's .get() method.
        //   var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
        //   var pieData        = donutData;
        //   var pieOptions     = {
        //     maintainAspectRatio : false,
        //     responsive : true,
        //   }
        //   //Create pie or douhnut chart
        //   // You can switch between pie and douhnut using the method below.
        //   new Chart(pieChartCanvas, {
        //     type: 'pie',
        //     data: pieData,
        //     options: pieOptions
        //   })

        //-------------
        //- BAR CHART -
        //-------------
        var barChartCanvas = $("#barChart").get(0).getContext("2d");
        var barChartData = $.extend(true, {}, areaChartData);
        var temp0 = areaChartData.datasets[0];
        var temp1 = areaChartData.datasets[1];
        barChartData.datasets[0] = temp1;
        barChartData.datasets[1] = temp0;

        var barChartOptions = {
          responsive: true,
          maintainAspectRatio: false,
          datasetFill: false,
        };

        new Chart(barChartCanvas, {
          type: "bar",
          data: barChartData,
          options: barChartOptions,
        });

        //---------------------
        //- STACKED BAR CHART -
        //---------------------
        var stackedBarChartCanvas = $("#stackedBarChart")
          .get(0)
          .getContext("2d");
        var stackedBarChartData = $.extend(true, {}, barChartData);

        var stackedBarChartOptions = {
          responsive: true,
          maintainAspectRatio: false,
          scales: {
            xAxes: [
              {
                stacked: true,
              },
            ],
            yAxes: [
              {
                stacked: true,
              },
            ],
          },
        };

        new Chart(stackedBarChartCanvas, {
          type: "bar",
          data: stackedBarChartData,
          options: stackedBarChartOptions,
        });
      });
    </script>

    <!-- Code injected by live-server -->
    <script>
      // <![CDATA[  <-- For SVG support
      if ("WebSocket" in window) {
        (function () {
          function refreshCSS() {
            var sheets = [].slice.call(document.getElementsByTagName("link"));
            var head = document.getElementsByTagName("head")[0];
            for (var i = 0; i < sheets.length; ++i) {
              var elem = sheets[i];
              var parent = elem.parentElement || head;
              parent.removeChild(elem);
              var rel = elem.rel;
              if (
                (elem.href && typeof rel != "string") ||
                rel.length == 0 ||
                rel.toLowerCase() == "stylesheet"
              ) {
                var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, "");
                elem.href =
                  url +
                  (url.indexOf("?") >= 0 ? "&" : "?") +
                  "_cacheOverride=" +
                  new Date().valueOf();
              }
              parent.appendChild(elem);
            }
          }
          var protocol =
            window.location.protocol === "http:" ? "ws://" : "wss://";
          var address =
            protocol + window.location.host + window.location.pathname + "/ws";
          var socket = new WebSocket(address);
          socket.onmessage = function (msg) {
            if (msg.data == "reload") window.location.reload();
            else if (msg.data == "refreshcss") refreshCSS();
          };
          if (
            sessionStorage &&
            !sessionStorage.getItem("IsThisFirstTime_Log_From_LiveServer")
          ) {
            console.log("Live reload enabled.");
            sessionStorage.setItem("IsThisFirstTime_Log_From_LiveServer", true);
          }
        })();
      } else {
        console.error(
          "Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading."
        );
      }
      // ]]>
    </script>
  </body>
</html>
