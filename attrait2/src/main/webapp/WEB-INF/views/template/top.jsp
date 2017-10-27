<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${context}/common/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/common/css/bootstrap-theme.css" rel="stylesheet">
<link href="${context}/common/css/common.css" rel="stylesheet">
<script src="${context}/common/js/jquery-1.9.1.js"></script>
<script src="${context}/common/js/common.js"></script>
<script src="${context}/common/js/bootstrap.min.js"></script>
<style type="text/css">
li{
	cursor: pointer;
}
a{
	text-decoration:none !important;
}
</style>
</head>


<c:set var="homeUrl">${context}/product/goMain</c:set>
<c:set var="loginUrl">${context}/user/login</c:set>

<c:set var="officeUrl">${context}/product/retrieveProductList?category=O</c:set>
<c:set var="penUrl">${context}/product/retrieveProductList?category=P</c:set>
<c:set var="binderUrl">${context}/product/retrieveProductList?category=B</c:set>
<c:set var="designUrl">${context}/product/retrieveProductList?category=D</c:set>
<c:set var="storageUrl">${context}/product/retrieveProductList?category=S</c:set>
<body>
	<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<div class="container" style="background-color: black;">
			<ul class="nav navbar-nav">
				<li><a href="${homeUrl}"><font color="white"><strong>HS STATIONERY</strong></font></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:if test="${sessionScope.id != null && sessionScope.grade != 'A'}">
						<a href="/cart/retrieveCartList"><font color="white"><strong>장바구니</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null && sessionScope.grade == 'A'}">
						<a href="/product/retrieveProductListForManage"><font color="white"><strong>재고관리</strong></font></a>
					</c:if>
				</li>
				<li>
					<c:if test="${sessionScope.id != null && sessionScope.grade != 'A'}">
						<a href="/sell/retrieveBuyList"><font color="white"><strong>구매내역</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null && sessionScope.grade == 'A'}">
						<a href="/sell/retrieveStatisticsForProduct"><font color="white"><strong>매출통계</strong></font></a>
					</c:if>
				</li>
				<li>
					<c:if test="${sessionScope.id == null}">
						<a href="/user/createUser"><font color="white"><strong>회원가입</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null && sessionScope.grade != 'A'}">
						<a href="/user/updateUser"><font color="white"><strong>정보수정</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null && sessionScope.grade == 'A'}">
						<a href="/product/retrieveStatisticsForStock?productCategoryCd=P"><font color="white"><strong>재고현황</strong></font></a>
					</c:if>
				</li>
				<li>
					<c:if test="${sessionScope.id == null}">
						<a href="/user/login"><font color="white"><strong>LOGIN</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null}">
						<a href="/user/logout"><font color="white"><strong>LOGOUT</strong></font></a>
					</c:if>
				</li>
			</ul>
		</div>
	</nav>
		<div class="container" style="background-color: white; margin-bottom: 2%;">
		<c:if test="${sessionScope.grade != 'A'}">
		  	<p style="font-size: 70px;"><a href="${context}/product/goMain" style="color: black;"><b>HS STATIONERY</b></a></p>
		  <ul class="list-inline">
		    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${penUrl}')" style="color: black; font-size: 25px;">필기류&nbsp;&nbsp;|</a></li>
		    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${officeUrl}')" style="color: black; font-size: 25px;">사무용품&nbsp;&nbsp;|</a></li>
		    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${storageUrl}')" style="color: black; font-size: 25px;">정리/수납용품&nbsp;&nbsp;|</a></li>
		    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${binderUrl}')" style="color: black; font-size: 25px;">화일/바인더&nbsp;&nbsp;|</a></li>
		    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${designUrl}')" style="color: black; font-size: 25px;">디자인문구&nbsp;&nbsp;</a></li>
		  </ul>
	  	</c:if>
	  	<c:if test="${sessionScope.id != null && sessionScope.grade == 'A'}">
	  		<p style="font-size: 70px;"><a href="/product/goMain" style="color: black;"><b>HS STATIONERY</b></a></p>
	  		<h1>관리자 모드입니다.</h1>
	  	</c:if>
	</div>
</body>
</html>