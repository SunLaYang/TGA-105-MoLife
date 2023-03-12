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
  <link rel="stylesheet" type="text/css" href="../../css/donate/N_4-1_memberCenter.css" />
  
  <!--Bootstrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
    crossorigin="anonymous"></script>
  
  <!-- JQuery -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  
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


<!-- 麵包屑 -->
<div class="path">
 <div class="container1">
  <ol class="breadcrumb" style="background-color:transparent;">
    <li class="breadcrumb-item"><a href="###" style="color:black;">首頁</a></li>
    <li class="breadcrumb-item"><a href="###" style="color:black;">會員中心</a></li>
    <li class="breadcrumb-item active" aria-current="page" style="color:#A7754D; text-decoration: underline;">募款管理</li>
  </ol>
  </div>
</div>


<!--提案募款紀錄-->
<div class="proposal-record">
 
 <div class="row">
  <div class="col-12">
    <div class="card">
      <div class="card-header">
        <h3 class="card-title" style="font-weight:bold;">提案募款紀錄</h3>
      </div>

      <!-- /.card-header -->
      <div class="card-body table-responsive p-0">
       
        <table class="table table-hover text-nowrap" style="text-align: center;">
          <thead>
            <tr>
              <th>提案日期</th>
              <th>計畫名稱</th>
              <th>計畫編號</th>
              <th>計畫進度</th> 
              <th>募款總額</th>
              <th>狀態更新</th>
              <th>系統備註</th>
            </tr>
          </thead>
          
          <tbody>
            <c:forEach var="planVO" items="${listAll}">
             <tr>
              <td>${planVO.proposalDate}</td>
              <td>${planVO.planName}</td>
              <td>${planVO.planId}</td>
              <td>${planVO.planStatusVO.planStatus}</td>
              <td>${planVO.donateAmount}</td>
             
              
              <td>
               <form METHOD="post" ACTION="<%=request.getContextPath()%>/pages/donate/UpdateStatusServlet">
              	<input type="hidden" name="id" value="${planVO.planId}">
              	  <c:if test="${planVO.planStatusId == 3}">
              	  <input type="hidden" name="memberAction" value="saveId">
              	  <input type="submit" id="submit" class="btn btn-outline-warning" value="更新"/>
              	  </c:if>
               </form>	  
              </td>
              
              <td>${planVO.planStatusComment}</td>
             </tr>
		    </c:forEach>
          </tbody>
        </table>
      
      </div>
      <!-- /.card-body -->
    </div>
    <!-- /.card -->
  </div>
 </div>
  
</div>




<!--我的捐款紀錄 -->
<div class="pay-record">
  <div class="row">
   <div class="col-12">
     <div class="card">
       <div class="card-header">
         <h3 class="card-title" style="font-weight:bold">我的捐款紀錄</h3>
       </div>
       <!-- /.card-header -->
        <div class="card-body table-responsive p-0">
          <table class="table table-hover text-nowrap" style="text-align: center;">
            <thead>
              <tr>
                <th>捐款日期</th>
                <th>捐款編號</th>
                <th>募款計畫名稱</th>
                <th>計畫編號</th>
                <th>計畫進度</th>
                <th>捐款金額</th>
              </tr>
            </thead>

            <tbody>
             <c:forEach var="paymentVO" items="${payList}">
              <tr>
                <td>${paymentVO.paymentDate}</td>
                <td>${paymentVO.paymentId}</td>
                <td>${paymentVO.planVO.planName}</td>
                <td>${paymentVO.planId}</td>
                <td>${paymentVO.planStatusVO.planStatus}</td>
                <td>${paymentVO.paymentAmount}</td>
              </tr>
              </c:forEach>
            </tbody>
            
         </table>
       </div>
       <!-- /.card-body -->
     </div>
     <!-- /.card -->
   </div>
  </div>
 </div>



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