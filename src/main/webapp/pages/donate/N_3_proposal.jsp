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
  <link rel="stylesheet" type="text/css" href="../../css/donate/N_3_proposal.css" />
  <!-- fontawesome -->
  <script src="https://kit.fontawesome.com/793f12a2cf.js" crossorigin="anonymous"></script>
   <!-- JQuery -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  <!--Bootstrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
    crossorigin="anonymous"></script>
    
  <!--sweetalert-->  
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
  <!-- header & footer (有修改路徑)-->
  <link
      rel="stylesheet"
      type="text/css"
      href="../../styles/bootstrap4/bootstrap.min.css"
    />
  <link rel="stylesheet" type="text/css" href="../../styles/main_styles.css" />
   <link rel="stylesheet" href="../../styles/room/room.css" />

</head>


<body>
 <!-- Header -->
  <header class="header trans_300">
    <!-- Main Navigation -->
      <div class="main_nav_container bg-yellow">
        <div>
          <div class="row">
            <div class="col-lg-12 text-right">
              <div class="logo_container">
                <a href="../../page/front_page.html"> <!-- ?? -->
                  <img src="../../images/home/logoMoLife.png" />
                </a>
              </div>
              <nav class="navbar">
                <ul class="navbar_menu">
                  <li>
                    <a href="./01room.index.html">寵物旅館</a>
                  </li>
                  <li><a href="#">商品專區</a></li>
                  <li><a href="<%=request.getContextPath()%>/pages/donate/N_1_index">寵物募款</a></li>
                  <li><a href="#">寵物論壇</a></li>
                  <li>
                    <a href="#">聯絡我們</a>
                  </li>
                  <li><a href="../../page/index.html">管理員後台</a></li><!-- ?? -->
                </ul>
                <ul class="navbar_user">
                  <a href="#"><img class="icon" src="../../images/home/car.png"/></a>
                  <a href="#"><img class="icon" src="../../images/home/ring.png"/></a>
                  <a href="#"><img class="icon" src="../../images/home/man.png"/></a>
                </ul>
                <div class="hamburger_container">
                  <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
              </nav>
            </div>
          </div>
        </div>
      </div>
</header>
<br>
<br>
<br>
<br>


 <!--carousel slide-->
 <div id="carouselExampleDark" class="carousel carousel-dark slide"  data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
  </div>
  <!-- 圖片元件-innnner關鍵字­-->
  <div class="carousel-inner">
     <!--第一張+active-->
    <div class="carousel-item active" data-bs-interval="10000">
      <img src="../../css/donate/donate_pic/1_banner_1.png" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../../css/donate/donate_pic/1_banner_2.png" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
      </div>
    </div>
  </div>
  <!--按鈕--->
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>


<!--麵包屑-->
<div class="path">
 <div class="container1">
  <ol class="breadcrumb" style="background-color:transparent;">
    <li class="breadcrumb-item"><a href="###" style="color:black;">首頁</a></li>
    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/pages/donate/N_1_index" style="color:black;">寵物募款</a></li>
    <li class="breadcrumb-item active" aria-current="page" style="color:#A7754D; text-decoration: underline;">我要提案募款</li>
  </ol>
  </div>
</div>



  <!-- 表單 -->
<form action="<%=request.getContextPath()%>/pages/donate/ProposalServlet" method="post" enctype="multipart/form-data" id="proposal-form">
  <section class="content">
    <div class="row">
      <div class="col-md-6">
        <div class="card card-primary">

          <div class="card-header"> 
            <h3 class="card-title" style="text-align: center;">提案募款表單</h3>
            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              </button>
            </div>
          </div>

        <div class="card-body">
          
            <div class="form-group">
              <label for="proposal_date">日期</label>
              <input type="date" id="proposal_date" class="form-control" name="proposalDate" style="color:black !important;">
                <script>
                  $(document).ready(function () {
                  var time = new Date();
                  var day = ("0" + time.getDate()).slice(-2);
                  var month = ("0" + (time.getMonth() + 1)).slice(-2);
                var today = time.getFullYear() + "-" + (month) + "-" + (day);
                $('#proposal_date').val(today);
                })
                </script>
            </div>


            <div class="form-group">
              <label for="plan_name">募款計畫名稱</label>
              <span  style="color:red">${errors.planName}</span>
              <input type="text" name="planName" value="${param.planName}" class="form-control" style="color:black !important;">
              
            </div>

            <div class="form-group">
              <label for="animal_type">動物種類</label>
              <span style="color:red">${errors.animalTypeId}</span>
              <select id="animal_type" name="animalTypeId" class="form-control custom-select" style="color:black !important;">
                <option selected disabled value="null">請選擇動物種類</option>
                <option value="1">狗狗</option>
                <option value="2">貓貓</option>
                <option value="3">兔兔</option>
                <option value="4">鼠類</option>
                <option value="5">其他</option>
              </select>
            </div>

            <div class="form-group">
              <label for="address">所在地址</label>
              <span style="color:red">${errors.address}</span>
              <input type="text" id="address" name="address" class="form-control" style="color:black !important;">
            </div>
            
            <div class="form-group">
              <label for="reason">募款原因描述</label>
               <span style="color:red">${errors.reason}</span>
              <textarea id="reason" class="form-control" name="reason" rows="4" style="color:black !important;"></textarea>
            </div>
            
            <div class="form-group">
              <label for="donate_days">募款所需天數</label>
              <span style="color:red">${errors.donateDays}</span>
              <input type="text" name="donateDays" class="form-control"  style="width: 200px; color:black !important;">
            </div>

            <div class="form-group">
              <label for="donate_goal">募款所需金額</label>
               <span style="color:red">${errors.donateGoal}</span>
              <input type="text" name="donateGoal" class="form-control"  style="width: 200px; color:black !important;">
            </div>
            
            <div class="form-group">
              <label for="animal_video_link">Youtube影片連結</label>
               <span style="color:red">${errors.animalVideoLink}</span>
              <input type="url" name="animalVideoLink" class="form-control" placeholder="https://www.youtube.com/" style="color:black !important;">
            </div>

            <div class="form-group">
              <label for="animal_photo">照片上傳</label>
               <span style="color:red">${errors.animalPhoto}</span>
              <input type="file" id="animal_photo" accept="image/*" name="animalPhoto">
            </div>
          </div>
          <!-- /.card-body -->
        </div>
        <!-- /.card -->
      </div>
    </div>
  </section>
  <div class="col-12">
  <input type="submit" id="proposal-submit" class="proposal-submit" value="送出">
  </div> 
</form>



<!-- 照片選擇JS -->
<script>
window.addEventListener("load", function(e) {
var p_file_el = document.getElementById("p_file");
});
</script>

<br>
<br>
<br>

<!-- Footer -->
<footer class="footer bg-yellow">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div
						class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
						<ul class="footer_nav">
							<li><a href="#">討論區</a></li>
							<li><a href="#">FAQs</a></li>
							<li><a href="contact.html">聯絡我們</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6">
					<div
						class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-skype"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest"
									aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer_nav_container">
						<div class="cr">
							©2022 All Rights Reserverd. Template by <a href="#">Colorlib</a>
							&amp; distributed by <a href="https://themewagon.com">Tibame
								TGA-105 第四組</a>
						</div>
					</div>
				</div>
			</div>
		</div>
</footer>
</body>
<script src="../../js/custom.js"></script>
</html>