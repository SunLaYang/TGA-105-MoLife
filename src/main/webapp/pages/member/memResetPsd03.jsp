<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.tibame.tga105.mem.model.MemVO"%>

<%
MemVO memVO = (MemVO) request.getAttribute("memVO"); //MemServlet.java (Concroller) 存入req的memVO物件 (包括幫忙取出的memVO, 也包括輸入資料錯誤時的memVO物件)
%>

<%-- <% memVO memVO = (memVO) request.getAttribute("memVO");%>> --%>

<%-- --<%=memVO == null%>--${memVO.memId}-- --%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>會員重設密碼</title>

<!--index_css-->
<!-- <link rel="stylesheet" type="text/css" href="N_1_index.css" /> -->

<!--Bootstrap導入程式-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>

<!-- JQuery導入 -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<!-- fontawesome導入 -->
<script src="https://kit.fontawesome.com/793f12a2cf.js"
	crossorigin="anonymous"></script>

<style>
div.login-box {
	margin: 150px 450px 10px 450px;
}

p.login-box-msg {
	font-size: 32px;
}

.login_button {
	position: relative;
}

div.btn_click {
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>
<link rel="stylesheet" type="text/css"
	href="../../styles/bootstrap4/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../../styles/main_styles.css" />
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
							<a href="/page/others/24front_page.html"> <img
								src="../../images/home/logoMoLife.png" />
							</a>
						</div>
						<nav class="navbar">
							<ul class="navbar_menu">
								<li><a href="/page/room/01room.index.html">寵物旅館</a></li>
								<li><a href="/page/shop/shop.html">商品專區</a></li>
								<li><a href="/pages/donate/N_1_index">寵物募款</a></li>
								<li><a href="/page/others/24forum.index.html">寵物論壇</a></li>
								<li><a href="/page/others/24contact.html">聯絡我們</a></li>
								<li><a href="/page/others/24admin.index.html">管理員後台</a></li>
							</ul>
							<ul class="navbar_user">
								<a href="/page/shop/shop-cart.html"><img class="icon"
									src="../../images/home/car.png" /></a>
								<a href="/page/others/24post_info.html"><img class="icon"
									src="../../images/home/ring.png" /></a>
								<a href="/pages/member/listOneMem.jsp"><img class="icon"
									src="../../images/home/man.png" /></a>
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



	<div class="login-box">
	<div class="col	text-center">
			<p class="login-box-msg">會員重設密碼</p>
	</div>
		<div style="margin-left: 40%">
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<form METHOD="post" ACTION="/memberController" name="ResetPsdFromEmail">
			<div class="col text-center">
				<div class="mail.text">
					<label for="exampleInputEmail1" style="color: #8d98a7;">請輸入新密碼</label>
					<input type="TEXT" name="memPsd" size="35" /> <br /> <br />
			</div>

			<jsp:useBean id="memSvc" scope="page"	class="com.tibame.tga105.mem.model.MemService" />
	</div>
		<div class="col text-center">
		<input type="hidden" name="action" value="ResetPsdFromEmail"> 
	    <input type="hidden" name="memEmail" value="<%=request.getParameter("memEmail")%>">
		<input class="btn btn-primary login_button" type="submit" value="確認重設密碼"	style="background-color: #A7754d; padding: 14px 100px;">
		</div>
	</form>

</div>
	<br />
	<br />
	<br />
	<br />
	<br />

	<!-- Footer -->
	<!-- Footer_start -->
	<footer class="footer bg-yellow">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div
						class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
						<ul class="footer_nav">
							<li><a href="/page/others/24forum.index.html">討論區</a></li>
							<li><a href="/page/others/24faq.html">FAQs</a></li>
							<li><a href="/page/others/24contact.html">聯絡我們</a></li>
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
