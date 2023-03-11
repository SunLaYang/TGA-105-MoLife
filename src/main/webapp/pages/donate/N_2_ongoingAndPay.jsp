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
<link rel="stylesheet" type="text/css" href="../../css/donate/N_2_ongoingAndPay.css" />

<script src="click.js"></script>

<!--Bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<!-- fontawesome -->
<script src="https://kit.fontawesome.com/793f12a2cf.js"
	crossorigin="anonymous"></script>
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
						<a href="#"> <img src="../../images/home/logoMoLife.png" />
						</a>
					</div>
					<nav class="navbar">
						<ul class="navbar_menu">
							<li><a href="#">寵物旅館</a></li>
							<li><a href="#">ååå°å</a></li>
							<li><a href="#">å¯µç©åæ¬¾</a></li>
							<li><a href="#">å¯µç©è«å£</a></li>
							<li><a href="#">è¯çµ¡æå</a></li>
							<li><a href="#">ç®¡çå¡å¾å°</a></li>
						</ul>
						<ul class="navbar_user">
							<a href="#"><img class="icon" src="../../images/home/car.png" /></a>
							<a href="#"><img class="icon"
								src="../../images/home/ring.png" /></a>
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

	<!--carousel slide-->
	<div id="carouselExampleDark" class="carousel carousel-dark slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleDark"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleDark"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
		</div>
		<!-- åçåä»¶-innnnerééµå­-->
		<div class="carousel-inner">
			<!--ç¬¬ä¸å¼µ+active-->
			<div class="carousel-item active" data-bs-interval="10000">
				<img src="donate_pic/1_banner_1.png" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<img src="donate_pic/1_banner_2.png" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
		</div>
		<!--æé-->
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleDark" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleDark" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>


	<!--bread-->
	<div class="path">
		<div class="container1">
			<ol class="breadcrumb" style="background-color: transparent;">
				<li class="breadcrumb-item"><a href="###" style="color: black;">首頁</a></li>
				<li class="breadcrumb-item"><a href="N_1_index.jsp" style="color: black;">寵物募款</a></li>
				<li class="breadcrumb-item active" aria-current="page"
					style="color: #A7754D; text-decoration: underline;">募款中計畫</li>
			</ol>
		</div>
	</div>


	<!-- animal type -->
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pages/donate/FindByAnimalServlet">
		<div class="wrapper-box">
			<div class="wrapper">
				<div class="search_box">


					<div class="dropdown">
						<div class="default_option">選擇動物類型</div>
						<ul>
							<li data-value="1">狗狗</li>
							<li data-value="2">貓貓</li>
							<li data-value="3">兔兔</li>
							<li data-value="4">鼠類</li>
							<li data-value="5">其他</li>
						</ul>
						<input type="hidden" name="animalTypeId" id="animalTypeId">
					</div>

					<div class="search_field">
						<input type="submit" class="input" id="search" value=""
							style="border: #A7754D 1px; border-radius: 5px"> <i
							class="fa-solid fa-magnifying-glass"></i>
					</div>


				</div>
			</div>
		</div>
	</FORM>


	<!-- 下拉式選單function -->
	<script>
		$(document).ready(function() {
			// 點擊出現選項
			$(".default_option").click(function() {
				$(".dropdown ul").toggleClass("active");
			});

			//選取某選項後，會將之呈現在標題位置，並remove選項
			$(".dropdown ul li").click(function() {
				var text = $(this).text();
				$(".default_option").text(text);
				var value = $(this).attr('data-value');
				$("#animalTypeId").val(value); //將value值設定到隱藏的input元素中
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




<!-- get one plan -->
	<div class="plan-container">
	  <c:forEach var="result" items="${results}">
		<div class="row">
			<!-- photo -->
			
			<div class="col-md-5">
			<!-- <img src="AnimalPhotoServlet?planId=${result.planId}" class="img-fluid"> -->
				<img src="AnimalPhotoServlet?planId=${result.planId}" class="img-fluid">
			</div>
			
			<!-- ID hidden -->
			<input type="hidden" name="planId">

			<!-- NAME -->
			<div class="col-md-7">
				<h2 class="plan-name2">${result.planName}</h2>

				<!--內容 -->
				<table>
					<tbody style="font-size: 18px; line-height: 35px;">

						<tr>
							<td>動物種類：</td>
							<td>${result.animalTypeVO.animalType}</td>
						</tr>

						<tr>
							<td>所在地址：</td>
							<td>${result.address}</td>
						</tr>

						<tr>
							<td>募款原因：</td>
							<td>${result.reason}</td>
						</tr>

						<tr>
							<td>截止日期：</td>
							<td>${result.donateEndDate}</td>
						</tr>

						<tr>
							<td>動物影片：</td>
							<td><a style="color: black" id="animal_video_link"
								href="${result.animalVideoLink}">觀看影片</a></td>
						</tr>
					</tbody>
				</table>

				<table>
					<tbody style="font-size: 18px; line-height: 35px;">

						<tr>
							<td>目標金額：</td>
							<td style="color: #A7754D; font-weight: bold;">$${result.donateGoal}</td>
						</tr>

						<tr>
							<td>已募金額：</td>
							<td style="color: #A7754D; font-weight: bold;">$${result.donateAmount}</td>
						</tr>

						<c:set var="gap" value="${result.donateAmount - result.donateGoal}"/>
						<tr>
							<td>尚差金額：</td>
							<td style="color: #A7754D; font-weight: bold;">$${gap}</td>
						</tr>
				</table>

			</div>


		</div>
	 </c:forEach>	
	</div>


	<br>
	<br>

	<!-- 狀態更新 -->	
	<div class="update">
		<p class="update-title">狀態更新</p>
		<table class="table table-hover">

			<thead class="update-thead">
				<tr>
					<th scope="col">日期</th>
					<th scope="col">描述</th>
					<th scope="col">照片</th>
					<!--  <th scope="col">影片</th> -->
				</tr>
			</thead>

			<tbody class="update-tbody">
				<c:if test="${not empty updateResult}">
					<c:forEach var="updateResult" items="${updateResult}">
						<tr>
							
							<td scope="row">${updateResult.updateDate}</td>
							<td id="update-text">${updateResult.updateText}</td>
							
							<c:if test="${not empty updateResult.updatePhoto}">
							<td>
							<input type="button" id="update-photo-button"
								onclick="location.href='UpdatePhotoServlet?updateId=${updateResult.updateId}';" value="看照片" /></td>
							</c:if>
							
							<c:if test="${empty updateResult.updatePhoto}">
							<td> </td>
							
							</c:if>		
							
							
							
							<!-- <img src="AnimalPhotoServlet?planId=${result.planId}" class="img-fluid"> -->
							
							<!--<td><input type="button" id="update-vidoe-link-button"
								onclick="location.href='';" value="看影片" /></td> -->
						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>
	</div>


	<!-- 捐款畫面 -->
<form method="post" ACTION="<%=request.getContextPath()%>/pages/donate/OnePlan">
	<div class="wrapper-pay">
		<div class="payment">

			<h2>Help Mo NOW<i class="fa-solid fa-heart"></i></h2>
				
				<div class="form">
					<div class="card icon-relative">
						<label class="label">捐款金額：</label>
						 <span  style="color:red">${errors.paymentAmount}</span>
						<input type="text" class="input" name="paymentAmount"> 
							<i class="fa-regular fa-dollar-sign"></i>
					</div>

					<div class="card icon-relative">
						<label class="label">持卡人：</label> 
						<input type="text" class="input" name="card-holder">
							<i class="fa-regular fa-face-smile-wink"></i>
					</div>

					<div class="card icon-relative">
						<label class="label">信用卡卡號：</label> 
						<input type="text" class="input" name="card-number"> 
							<i class="fa-regular fa-credit-card"></i>
					</div>

					<div class="card-group">
						<div class="card-item icon-relative">
							<label class="label">有效月/年：</label> 
							<input type="text" class="input" name="expiry-date" placeholder="00 / 00">
							<i class="fa-solid fa-calendar-days"></i>
						</div>

						<div class="card-item icon-relative">
							<label class="label">末三碼：</label> 
							<input type="text" class="input" name="cvc" placeholder="000"> 
								<i class="fa-solid fa-lock"></i>
						</div>
					</div>
					    <input type="hidden" name="paymentDate" id="paymentDate">
					<div>
						<!-- ID hidden -->
						 <c:forEach var="result" items="${results}">
						<input type="hidden" name="planId" value="${result.planId}">
						<input type="hidden" name="payAction" value="pay">
						<input class="pay-btn" type="submit" id="pay-btn" value="送出" />
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</form>
	
	
	
<!-- 彈跳視窗問題-->
<script>
  // 取得提交按钮元素
  var submitBtn = document.getElementById("pay-btn");
  // 在按钮上註冊點擊事件監聽器
  submitBtn.addEventListener("click", function() {
    alert("修改成功！");
  });
</script>


<!-- 日期設定 -->
	<script>
		function getCurrentDateTime() {
			var now = new Date();
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var day = now.getDate();
			var hours = now.getHours();
			var minutes = now.getMinutes();
			var seconds = now.getSeconds();
			var formattedDateTime = year + '-' + addZeroPadding(month) + '-'
					+ addZeroPadding(day) + ' ' + addZeroPadding(hours) + ':'
					+ addZeroPadding(minutes) + ':' + addZeroPadding(seconds);
			return formattedDateTime;
		}

		function addZeroPadding(num) {
			return (num < 10 ? '0' + num : num);
		}

		document.getElementById("paymentDate").value = getCurrentDateTime();
	</script>
	





<br>
<br>
<br>
<br>

	<!-- Footer -->
	<!-- Footer_start -->
	<div id="footer"></div>
	<!-- Footer_end -->


	<!-- å¼å¥ header / footer /scrollTop-->
	<script>
		$(function() {
			$("#header").load("../../header.html");
			$("#footer").load("../../footer.html");
			$("#scrollTop").load("../../scrollTop.html");
		});
	</script>
</body>

</html>