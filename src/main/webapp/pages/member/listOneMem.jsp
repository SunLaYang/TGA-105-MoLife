<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@
page import="com.tibame.tga105.mem.model.*"%>
<%@ page import="com.tibame.tga105.mem.model.MemVO"%>
<%@ page import="com.tibame.tga105.mem.model.MemService"%>
<%
MemVO memVO = (MemVO) request.getAttribute("memVO");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>會員單筆資料查詢</title>

<!--index_css-->
<link rel="stylesheet" type="text/css" href="N_1_index.css" />
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
.sidenav {
	width: 130px;
	position: sticky;
	z-index: 1;
	top: 110px;
	left: 10px;
	background: rgb(255, 255, 255);
	overflow-x: hidden;
	padding: 8px 0;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.memlistonebox {
	margin-left: 25%;
}

table {
	width: 500px;
	background-color: white;
}

th, td {
	padding: 5px;
	text-align: center;
	color: #646e78;
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
								<a href="#"><img class="icon"
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

	<div style="margin-top: 8%;">
		<div style="display: flex; flex-direction: row">
			<div class="sidenav">
				<a href="/pages/member/listOneMem.jsp" style="margin-bottom: 10%;">帳號設定</a> <a
					href="/page/shop/shop-orders.html" style="margin-bottom: 10%;">訂單查詢</a> <a
					href="/page/shop/shop-collection.html" style="margin-bottom: 10%;">商品收藏</a> <a
					href="/page/room/01myOrder.html" style="margin-bottom: 10%;">房型訂單明細</a> <a
					href="/pages/donate/N_4-1_memberCenter" style="margin-bottom: 10%;">募款管理</a> 
			</div>
			<div class="col text-center">
				<div class="memlistonebox">
					<table>
						<tr>
							<td>會員頭像</td>
							<td><img src="/MemPicView?memId=${memVO.memId}" width="200"
								height="200" id="mempic" /></td>
						</tr>
						<tr>
							<td>會員編號</td>

							<td>${memVO.memId}</td>
						</tr>
						<tr>
							<td>會員姓氏</td>
							<td>${memVO.memLname}</td>
						</tr>
						<tr>
							<td>會員名稱</td>
							<td>${memVO.memFname}</td>
						</tr>
						<tr>
							<td>會員暱稱</td>
							<td>${memVO.memNickname}</td>
						</tr>
						<tr>
							<td>會員信箱</td>
							<td>${memVO.memEmail}</td>
						</tr>
						<tr>
							<td>會員密碼</td>
							<td>${memVO.memPsd}</td>
						</tr>
						<tr>
							<td>會員手機</td>
							<td>${memVO.memPhone}</td>
						</tr>
						<tr>
							<td>會員地址</td>
							<td>${memVO.memAddress}</td>
						</tr>
						<tr>
							<td>會員註冊時間</td>
							<td>${memVO.registrationDate}</td>
							<!-- 							              <tr> -->
							<!-- 							                <td>會員檢舉</td> -->
							<%-- 							                <td>${memVO.postSuspended}</td> --%>
							<!-- 							              </tr> -->
						<tr>
							<td></td>
							<td>
								<FORM METHOD="post" ACTION="/memberController"
									style="margin-bottom: 0px" enctype="multipart/form-data">
									<input class="btn btn-primary edit_button" type="submit"
										value="修改"
										style="background-color: #a7754d; padding: 12px 50px; margin-bottom: 4%;" ;
                    />
									<input type="hidden" name="memId" value="${memVO.memId}" /> <input
										type="hidden" name="action" value="getOne_For_Update" />
								</FORM>
								
								<FORM METHOD="get" ACTION="/memberController"
									style="margin-bottom: 0px" enctype="multipart/form-data">
									<input class="btn btn-primary edit_button" type="submit"
										value="登出"
										style="background-color: #a7754d; padding: 12px 50px; margin-bottom: 4%;" ;
                    />
									<input type="hidden" name="memId" value="${memVO.memId}" /> <input
										type="hidden" name="action" value="logout" />
								</FORM>
								
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

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
