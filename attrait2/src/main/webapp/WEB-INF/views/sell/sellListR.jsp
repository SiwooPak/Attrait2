<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="sellListR.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>문구점</title>

	<link href="${context}/common/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/common/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/common/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/common/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

    <link href="${context}/common/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${context}/common/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="${context}/common/js/jquery-1.9.1.js"></script>
	<script src="${context}/common/js/bootstrap.min.js"></script>

    <script src="${context}/common/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/common/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${context}/common/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <script src="${context}/common/js/sb-admin-2.js"></script>

    <script>
	var existFolder = '';
	var imageFolder = '';
	var path = '';

    $(document).ready(function() {
//         $('#dataTables-example').dataTable();

    });

    function fn_eval(self, resumePassYn, examNo){
   		$.ajax({
   			url:"${context}/applicant/updateEvalForResume?resumePassYn=" + resumePassYn + "&examNo=" + examNo,
   			success:function(result){
   				result = result.replace(/"/gi, "");
   				self.parent().next().children().html(result);
   			}
   		});
    }

    function fn_selEval(resumePassYn){
		var checked = $("input[name='chkBox']:checked");
		var checkedCnt = $("input[name='chkBox']:checked").length;

		var examNo = "";

		for(var i = 0; i < checkedCnt; i++){
			examNo = checked.eq(i).parent().parent().children("td").eq(3).html();
			$.ajax({
	   			url:"${context}/applicant/updateEvalForResume?resumePassYn=" + resumePassYn + "&examNo=" + examNo,
	   			async: false,
	   			success:function(result){
	   				result = result.replace(/"/gi, "");
	   				checked.eq(i).parent().parent().children("td").eq(10).html(result);
	   			}
	   		});
		}
    }

    function fn_resumeDetail(self){
    	var examNo = self.parent().parent().children("td").eq(3).html();

    	location.href = "${context}/applicant/retrieveResumeDetail?examNo=" + examNo;
    }

    function fn_save(){
    	var examNo = '${dsSellList[0].examNo}';

		if(confirm("서류심사를 완료하시겠습니까?")){
			location.href = "${context}/incruit/updateIStatusForResume?examNo=" + examNo;
		}
    }

    function fn_finalBuy(paramSellCode, paramSellCount, paramProductCode){
		if(confirm("결제하시겠습니까?")){
			location.href = "${context}/sell/updateFinalBuy?sellCode=" + paramSellCode + "&sellCount=" + paramSellCount + "&productCode=" + paramProductCode;
		}
    }
    </script>
</head>
<body>
<!-- content start -->
	<div id="jumbotron" class="container">
		<div class="jumbotron jumbotron-info" style="background-color: lightgray;">
			<h1><font color="black"><strong>주문정보</strong>&nbsp;<i class="fa fa-credit-card fa-1x"></i></font></h1>
			<p>주문 정보를 확인해주세요</p>
		</div>

		<div class="row">
			<div class="col-md-12">
			    <div class="panel panel-default">
			        <!-- /.panel-heading -->
			        <div class="panel-body">
			            <div class="table-responsive">
			                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			                    <thead>
			                        <tr>
			                        	<th style="text-align: center; vertical-align: middle; width: 30px;">상품코드번호</th>
			                            <th style="text-align: center; vertical-align: middle; width: 30px;">상품이미지</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">상품이름</th>
			                            <th style="text-align: center; vertical-align: middle; width: 30px;">상품단가</th>
			                            <th style="text-align: center; vertical-align: middle; width: 50px;">상품수량</th>
			                            <th style="text-align: center; vertical-align: middle; width: 30px;">결제금액</th>
			                            <th style="text-align: center; vertical-align: middle; width: 20px;">결제</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<c:forEach items="${dsSellList}" var="dsSellList" varStatus="sellIdx">
			                         <tr>
			                         	<td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_CODE}</td>
			                            <td style="text-align: center; vertical-align: middle;">
			                            <c:choose>
			                            	<c:when test="${dsSellList.PRODUCT_CATEGORY_CD eq 'B'}">
			                            		<img name="image" width="110px" height="110px" src="${context}/binderImg/${dsSellList.PRODUCT_IMAGE}" class="img-thumbnail">
			                            	</c:when>
			                            	<c:when test="${dsSellList.PRODUCT_CATEGORY_CD eq 'O'}">
			                            		<img name="image" width="110px" height="110px" src="${context}/officeImg/${dsSellList.PRODUCT_IMAGE}" class="img-thumbnail">
			                            	</c:when>
			                            	<c:when test="${dsSellList.PRODUCT_CATEGORY_CD eq 'S'}">
			                            		<img name="image" width="110px" height="110px" src="${context}/storageImg/${dsSellList.PRODUCT_IMAGE}" class="img-thumbnail">
			                            	</c:when>
			                            	<c:when test="${dsSellList.PRODUCT_CATEGORY_CD eq 'D'}">
			                            		<img name="image" width="110px" height="110px" src="${context}/designImg/${dsSellList.PRODUCT_IMAGE}" class="img-thumbnail">
			                            	</c:when>
			                            	<c:otherwise>
			                            		<img name="image" width="110px" height="110px" src="${context}/penImg/${dsSellList.PRODUCT_IMAGE}" class="img-thumbnail">
			                            	</c:otherwise>
			                            </c:choose>
										
			                            </td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.PRODUCT_NAME}</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.PRODUCT_UNIT_PRICE}원</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_COUNT}</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_PRICE}원</td>
			                            <td style="text-align: center; vertical-align: middle;">
			                            	<button type="button" class="btn btn-primary" onclick="fn_finalBuy('${dsSellList.SELL_CODE}', '${dsSellList.SELL_COUNT}', '${dsSellList.PRODUCT_CODE}')">결제하기</button>
			                            </td>
			                         </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
			            </div>
			            <!-- /.table-responsive -->
			        </div>
			        <!-- /.panel-body -->
			    </div>
			    <!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-md-1 col-md-offset-11">
				<button type="button" class="btn btn-success btn-lg"  style="float:right;" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</div>
<!-- content end -->
</body>
</html>