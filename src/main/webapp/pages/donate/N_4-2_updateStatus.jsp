<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mo Life</title>

  <!--index_css-->
  <link rel="stylesheet" type="text/css" href="../../css/donate/N_4-2_updateStatus.css" />
  

  <!--Bootstrapå°å¥ç¨å¼-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
    crossorigin="anonymous"></script>
  
  <!-- JQueryå°å¥ -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
   <!-- sweetalert -->
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
</head>


<body>
  <!-- Header -->
  <div id="header"></div>

  <!-- Main Navigation -->
    <div class="main_nav_container bg-yellow">
      <div>
        <div class="row">
          <div class="col-lg-12 text-right">
            <div class="logo_container">
              <a href="#">
                <img src="../../images/home/logoMoLife.png" />
              </a>
            </div>
            <nav class="navbar">
              <ul class="navbar_menu">
                <li><a href="#">寵物旅館</a></li>
                <li><a href="#">商品專區</a></li>
                <li><a href="#">寵物募款</a></li>
                <li><a href="#">寵物論壇</a></li>
                <li><a href="#">聯絡我們</a></li>
                <li><a href="#">管理員後台</a></li>
              </ul>
              <ul class="navbar_user">
                <a href="#"><img class="icon" src="../../images/home/car.png" /></a>
                <a href="#"><img class="icon" src="../../images/home/ring.png" /></a>
                <a href="#"><img class="icon" src="../../images/home/man.png" /></a>
              </ul>
              <div class="hamburger_container">
                <i class="fa fa-bars" aria-hidden="true"></i>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>


<!--麵包屑-->
<div class="path">
 <div class="container1">
  <ol class="breadcrumb" style="background-color:transparent;">
    <li class="breadcrumb-item"><a href="###" style="color:black;">首頁</a></li>
    <li class="breadcrumb-item"><a href="###" style="color:black;">會員中心</a></li>
    <li class="breadcrumb-item"><a href="N_4-1_memberCenter.jsp" style="color:black;">募款管理</a></li>
    <li class="breadcrumb-item active" aria-current="page" style="color:#A7754D; text-decoration: underline;">狀態更新</li>
  </ol>
  </div>
</div>


  <!-- 表單 -->
<form action="<%=request.getContextPath()%>/pages/donate/UpdateStatusServlet" method="post" enctype="multipart/form-data">
<section class="content">
  <div class="row">
    <div class="col-md-6">
      <div class="card card-primary">

        <div class="card-header"> 
          <h3 class="card-title" style="text-align: center;">狀態更新表單</h3>
          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
            </button>
          </div>
        </div>

        <div class="card-body" style="font-size: 18px;">
        
          <div class="form-group">
            <label for="update_date">日期</label>
            <input type="date" id="update_date" class="form-control" name="updateDate">
              <script>
                $(document).ready(function () {
                var time = new Date();
                var day = ("0" + time.getDate()).slice(-2);
                var month = ("0" + (time.getMonth() + 1)).slice(-2);
              var today = time.getFullYear() + "-" + (month) + "-" + (day);
              $('#update_date').val(today);
              })
              </script>
          </div>
          
          <div class="form-group">
            <label for="update_text">更新狀態描述</label>
            <textarea class="form-control" id="update_text" name="updateText" rows="4" ></textarea>
          </div>
          
          <!--  
          <div class="form-group">
            <label for="update_video_link">Youtube影片連結</label>
            <input type="url" id="update_video_link" class="form-control" name="updateVideoLink" placeholder="https://www.youtube.com/">
          </div> -->

          <div class="form-group">
            <label for="p_file">照片上傳</label>
            <input type="file" id="p_file" accept="image/*" name="updatePhoto">
          </div>
          
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </div>
  </div>
</section>
 <div class="col-12">
 <!-- <input type="text" name="id" value="${planVO.planId}"> -->
 <input type="hidden" name="memberAction" value="update">
 <input type="submit" class="update-submit" id="update-submit" value="送出" />
 </div> 
</form>

<br>

<!-- 彈跳視窗-->
<script>
  // 取得提交按钮元素
  var submitBtn = document.getElementById("update-submit");
  // 在按钮上註冊點擊事件監聽器
  submitBtn.addEventListener("click", function() {
    alert("更新成功！");
  });
</script>

<!-- 照片選擇JS -->
<script>
  window.addEventListener("load", function(e) {
  var p_file_el = document.getElementById("p_file");
  });
</script>


<br>
<br>

<!-- Footer -->
<!-- Footer_start -->
<div id="footer"></div>
<!-- Footer_end -->


<!-- å¼å¥ header / footer /scrollTop-->
<script>
  $(function () {
    $("#header").load("../../header.html");
    $("#footer").load("../../footer.html");
    $("#scrollTop").load("../../scrollTop.html");
  });
</script>

</body>

</html>