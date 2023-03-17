<%@page import="com.tibame.tga105.admin.VO.AdminVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
AdminVO adminVO = (AdminVO) request.getAttribute("adminVO");
%>
<%-- <% AdminVO adminVO = (AdminVO) request.getAttribute("adminVO");%>> --%>

<%-- --<%=adminVO == null%>--${adminVO.adminId}-- --%>





<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>MoLife 員工登入</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/fontawesome-free/css/all.min.css" />
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css" />
<!-- iCheck -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/icheck-bootstrap/icheck-bootstrap.min.css" />
<!-- JQVMap -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/jqvmap/jqvmap.min.css" />
<!-- Theme style -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/dist/css/adminlte.min.css" />
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" />
<!-- Daterange picker -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/daterangepicker/daterangepicker.css" />
<!-- summernote -->
<link rel="stylesheet"
	href="../../AdminLTE-3.2.0/plugins/summernote/summernote-bs4.min.css" />

<script src="https://kit.fontawesome.com/2672c0b72c.js"
	crossorigin="anonymous"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<p>員工登入</p>
		</div>
		<!-- /.login-logo -->

		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<div class="card">
			<div class="card-body login-card-body">

				<form METHOD="post" ACTION="/adminController" name="login">

					<div class="input-group mb-3">
						<input type="TEXT" name="empAcc" class="form-control"
							placeholder="員工帳號" />
						<div class="input-group-append">
							<div class="input-group-text"></div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" name="empPsd" class="form-control"
							placeholder="密碼" />
						<div class="input-group-append">
							<div class="input-group-text"></div>
						</div>
					</div>
					<jsp:useBean id="admSvc" scope="page"
					class="com.tibame.tga105.admin.service.AdminService" />
				<div class="social-auth-links text-center mb-3">
					<input type="hidden" name="action" value="login"> <input
						type="submit" class="btn btn-primary btn-block" value="登入">
				</div>
				<p class="mb-1">
				</p>
				</form>

				<!-- /.social-auth-links -->

				
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../../dist/js/adminlte.min.js"></script>
</body>
</html>
