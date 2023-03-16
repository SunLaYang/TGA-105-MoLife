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
  <!-- /MoLife/src/main/webapp    /pages/donate/N_1_index.jsp -->
  <!-- /MoLife/src/main/resources/static/css/donate/N_1_index.css -->
  <!-- /MoLife/src/main/resources/static/styles/main_styles.css -->
  <link rel="stylesheet" type="text/css" href="../../css/donate/N_1_index.css" />
  
  <!--Bootstrap導入程式-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
    crossorigin="anonymous"></script>
  
  
  <!-- JQuery導入 -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  <!-- fontawesome導入 -->
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
      <div class="main_nav_container" style="background-color: #EAB464">
        <div>
          <div class="row">
            <div class="col-lg-12 text-right">
              <div class="logo_container">
                <a href="<%=request.getContextPath()%>/page/others/24front_page.html">
                  <img src="../../images/home/logoMoLife.png" />
                </a>
              </div>
              <nav class="navbar">
                <ul class="navbar_menu">
                  <li>
                    <a href="<%=request.getContextPath()%>/page/room/01room.index.html">寵物旅館</a>
                  </li>
                  <li><a href="<%=request.getContextPath()%>/page/shop/shop.html">商品專區</a></li>
                  <li><a href="<%=request.getContextPath()%>/pages/donate/N_1_index">寵物募款</a></li>
                   <li><a href="<%=request.getContextPath()%>/page/others/24forum.index.html">寵物論壇</a></li>
                  <li>
                    <a href="<%=request.getContextPath()%>/page/others/24contact.html">聯絡我們</a>
                  </li>
                  <li><a href="<%=request.getContextPath()%>/page/others/24admin.index.html">管理員後台</a></li>
                </ul>
                <ul class="navbar_user">
                  <li> <a href="#"><img class="icon" src="../../images/home/car.png"/></a>  </li>
                  <li> <a href="#"><img class="icon" src="../../images/home/ring.png"/></a> </li>
                  <li> <a href="#"><img class="icon" src="../../images/home/man.png"/></a>  </li>
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
  <!-- 圖片元件-innnner關鍵字-->
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
  <!--按鈕-->
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
    <li class="breadcrumb-item"><a href="###" style="color:black;">首頁</a></li>
    <li class="breadcrumb-item active" aria-current="page" style="color:#A7754D; text-decoration: underline;">寵物募款</li>
  </ol>
  </div>
</div>


<!-- 下拉式選單搜尋功能 -->
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pages/donate/FindByAnimalServlet">
<div class="wrapper-box">
  <div class="wrapper">
    <div class="search_box">
        <div class="dropdown">
          <div class="default_option">選擇動物類型</div>
          <ul>
            <li data-value="1">狗狗</li>
            <li data-value="2">貓貓</li>
            <li data-value="3">兔兔</li>
            <li data-value="4">鼠類</li>
            <li data-value="5">其他</li>
          </ul>
          <input type="hidden" name="animalTypeId" id="animalTypeId">
        </div>
   
      <div class="search_field">
          <input type="submit" class="input" id="search" value="" style="border:#A7754D 1px ; border-radius:5px">
          <i class="fa-solid fa-magnifying-glass"></i>
      </div>
      
    </div>
  </div>
</div>
</FORM>


 <!-- 下拉式選單function -->
 <script>  
  $(document).ready(function(){
      // 點擊出現選項
    $(".default_option").click(function(){
          $(".dropdown ul").toggleClass("active");
    });
    
      //選取某選項後，會將之呈現在標題位置，並remove選項
  $(".dropdown ul li").click(function(){
      var text = $(this).text();
      $(".default_option").text(text);
      var value = $(this).attr('data-value');
      $("#animalTypeId").val(value); // 將value值設定到隱藏的input元素中
      $(".dropdown ul").removeClass("active");
    })
  });
</script>


<!--提案募款-->
<div class="wrapper-pps">
  <div class="wrapper">
    <a href="N_3_proposal.jsp" style="color:white;">
      <button class="proposal">我要提案募款</button>
    </a>
  </div>
</div>



<!-- 計畫卡片 -->
<!-- 募款計畫標頭 -->
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<hr style= "background-color:#d8dfe7">
<div class="plan-title">募款中計畫</div>

<!-- 募款計畫卡片 "request.getContextPath()"-->

<div class="row">
	<c:forEach var="planVO" items="${listAll}">
   		<div class="col-sm-12 col-md-4">
    		<div class="card">
      				<img src="AnimalPhotoServlet?planId=${planVO.planId}" class="card-img-top" width="100%" height="100px">
      			<div class="card-body">
        			<div class="card-title">${planVO.planName}</div>
        			<p class="card-text">${planVO.reason}</p>
        	<form METHOD="post" ACTION="<%=request.getContextPath()%>/pages/donate/OnePlan">
        			<!-- planId -->
      				<input type="hidden" value="${planVO.planId}" name="planId">
      				
      				<input type="submit" class="plan-btn" style="color:black;" value="查看詳情">
      				<input type="hidden" name="planAction" value="GetOnePlan">
      				<input type="hidden" name="updateAction" value="GetUpdate">
             </form>
      			</div>
    		</div>
    	</div>
	</c:forEach>
</div>




 <!-- 問與答標頭 -->
<br>
<br>
<hr style= "background-color:#d8dfe7">
<div class="qa-title">常見問與答</div>

  <!-- 第一個問題 -->
<div class="card-qa">
  <div class="card-qa-body">
    <h5 class="card-qa-title">Q&nbsp;:&nbsp;請問募款主要對象是哪些？</h5>
    <p class="card-qa-text">
      A&nbsp;:&nbsp;<span style="color:#A7754D; font-weight: bold;">我們主要幫助被棄養或是流浪的動物們</span>，這些浪孩子常因飢餓而苟延殘喘，或是被野狗、不肖人士攻擊的情況屢見不鮮，<br>
      &emsp;&ensp;希望透過我們的一份力，讓浪孩子遇到的問題獲得幫助<br>
    </p>
  </div>
</div>

<!-- 第二個問題 -->
<div class="card-qa">
  <div class="card-qa-body">
    <h5 class="card-qa-title">Q&nbsp;:&nbsp;我在路上發現有小動物需要幫忙，請問我該如何提案？</h5>
    <p class="card-qa-text">
      A&nbsp;:&nbsp;若大家在街頭發現需要幫助的小動物，歡迎點擊最上方的<span style="color:#A7754D; font-weight: bold;"> "我要提案募款" </span>，<br>
      &emsp;&ensp;我們將於一個工作天內審核，若審核成功將上架計畫，號召大家的愛心進行協助，待康復後，我們將進行動物放生或是轉介給認養服務單位，幫助浪孩子們再次有個溫暖的家。
    </p>
  </div>
</div>

  <!-- 第三個問題 -->
<div class="card-qa">
  <div class="card-qa-body">
    <h5 class="card-qa-title">Q&nbsp;:&nbsp;如何得知捐款之款項運用情形？</h5>
    <p class="card-qa-text">
      A&nbsp;:&nbsp;會請募款提案者時時<span style="color:#A7754D; font-weight: bold;">更新狀態</span>，並上傳動物醫院的醫藥費收據，或購買飼料等所需用品的發票，以利各位愛心捐款者清楚款項去向。
    </p>
  </div>
</div>


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
