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
  <link rel="stylesheet" type="text/css" href="../../css/donate/N_6_paySuccess.css" />
  
  <!--Bootstrapå°å¥ç¨å¼-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
    crossorigin="anonymous"></script>
  
  <!-- JQueryå°å¥ -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  <!-- fontawesomeå°å¥ -->
  <script src="https://kit.fontawesome.com/793f12a2cf.js" crossorigin="anonymous"></script>
	
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
                <a href="../../page/front_page.html"> 
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
                  <a href="#"
                    ><img class="icon" src="../../images/home/car.png"
                  /></a>
                  <a href="#"
                    ><img class="icon" src="../../images/home/ring.png"
                  /></a>
                  <a href="#"
                    ><img class="icon" src="../../images/home/man.png"
                  /></a>
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

<!--麵包屑-->
<br>
<br>
<div class="path">
 <div class="container1">
  <ol class="breadcrumb" style="background-color:transparent;">
    <li class="breadcrumb-item"><a href="###" style="color:black;">首頁</a></li>
    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/pages/donate/N_1_index" style="color:black;">寵物募款</a></li>
  </ol>
  </div>
</div>


<!-- pay success -->
<br>
<h3 style="text-align: center; font-weight: bold; color:#A7754D;">已送出 <i class="fa-regular fa-circle-check"></i></h3>
<h5 style="text-align: center; font-weight: bold; color:#A7754D;">我們將於兩個工作日內進行審核，謝謝您的提案</h5>
<div class="payResult">
  <div class="textResult">
   
    <h6>提案編號：${result.planId}</h6>
    <h6>提案計畫名稱：${result.planName}</h6>
   
  </div>
</div>



<br>
<br>
<br>
<br>
<br>
<br>
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
