<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="productListR.jsp">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HS VOTE</title>

<link href="${context}/common/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/common/css/bootstrap-theme.css" rel="stylesheet">
<link href="${context}/common/css/plugins/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="${context}/common/css/plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<link href="${context}/common/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${context}/common/font-awesome-4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="${context}/common/js/jquery-1.9.1.js"></script>
<script src="${context}/common/js/bootstrap.min.js"></script>

<script src="${context}/common/js/plugins/metisMenu/metisMenu.min.js"></script>

<script
	src="${context}/common/js/plugins/dataTables/jquery.dataTables.js"></script>
<script
	src="${context}/common/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<script src="${context}/common/js/sb-admin-2.js"></script>

<script>
	var existFolder = '';
	var imageFolder = '';
	var path = '';

	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});

	function fn_showResult(paramVoteCode, paramVoteCount) {
		if (paramVoteCount == 0) {
			alert("참여자가 없습니다.");
		} else {
			location.href = "${context}/work/result/retrieveResult?voteCode="
					+ paramVoteCode;
		}
	}

	function fn_checkVote(paramVoteCode) {
		var param = {};

		param["voteCode"] = paramVoteCode;

		$.ajax({
			url : "${context}/result/retrieveExampleNo",
			contentType : "application/json",
			dataType : "json",
			data : param,
			success : function(result) {
				if (result["checkMsg"] == "success") {
					fn_doVote(paramVoteCode);
					return true;
				} else if (result["checkMsg"] == "fail") {
					alert("이미 투표하셨습니다.");
					return false;
				}
			}
		});
	}
</script>

</head>
<body>
	<!-- content start -->
	<br>
	<br>
	<br>
	<div class="container">
		<div class="page-header">
			<h1>${dsProductList[0].PRODUCT_CATEGORY_CD_NM}</h1>
		</div>
		<div class="jumbotron">
			<div class="row">
				<c:forEach items="${dsProductList}" var="dsProductList"
					varStatus="dsProductIdx">
					<div class="col-md-6">
						<c:choose>
							<c:when test="${dsProductList.PRODUCT_CATEGORY_CD eq 'P'}">
								<a
									href="${context}/product/retrieveProduct?productCode=${dsProductList.PRODUCT_CODE}"><img
									name="image"
									src="${context}/penImg/${dsProductList.PRODUCT_IMAGE}"
									class="img-thumbnail"></a>
							</c:when>
							<c:when test="${dsProductList.PRODUCT_CATEGORY_CD eq 'O'}">
								<a
									href="${context}/product/retrieveProduct?productCode=${dsProductList.PRODUCT_CODE}"><img
									name="image"
									src="${context}/officeImg/${dsProductList.PRODUCT_IMAGE}"
									class="img-thumbnail"></a>
							</c:when>
							<c:when test="${dsProductList.PRODUCT_CATEGORY_CD eq 'S'}">
								<a
									href="${context}/product/retrieveProduct?productCode=${dsProductList.PRODUCT_CODE}"><img
									name="image"
									src="${context}/storageImg/${dsProductList.PRODUCT_IMAGE}"
									class="img-thumbnail"></a>
							</c:when>
							<c:when test="${dsProductList.PRODUCT_CATEGORY_CD eq 'D'}">
								<a
									href="${context}/product/retrieveProduct?productCode=${dsProductList.PRODUCT_CODE}"><img
									name="image"
									src="${context}/designImg/${dsProductList.PRODUCT_IMAGE}"
									class="img-thumbnail"></a>
							</c:when>
							<c:otherwise>
								<a
									href="${context}/product/retrieveProduct?productCode=${dsProductList.PRODUCT_CODE}"><img
									name="image"
									src="${context}/binderImg/${dsProductList.PRODUCT_IMAGE}"
									class="img-thumbnail"></a>
							</c:otherwise>
						</c:choose>

						<div class="row"
							style="background-color: white; margin-left: 0.01%; width: 93%; height: 130px; border: 1px solid lightgray;">
							<div class="col-md-12">
								<h4>
									<font color="red"><b>${dsProductList.PRODUCT_NAME}</b></font>
								</h4>
							</div>
							<div class="col-md-12">
								<h4 style="font-family: inherit;">
									<b>${dsProductList.PRODUCT_UNIT_PRICE}원</b>
								</h4>
							</div>
							<div class="col-md-12">
								<h4 style="font-family: inherit;">
									<font color="lightblack"><b>남은 수량 :
											${dsProductList.PRODUCT_COUNT}</b></font>
								</h4>
							</div>
						</div>
						<c:if test="${dsProductIdx.index % 2 == 1}">
							&nbsp;
						</c:if>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- content end -->
</body>
</html>