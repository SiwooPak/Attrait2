<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="login.jsp">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">

    <title>HS ELECTRIC LOGIN</title>

    <link href="${context}/common/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/common/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="${context}/common/css/sb-admin-2.css" rel="stylesheet">
    <link href="${context}/common/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- jQuery -->
    <script src="${context}/common/js/jquery-1.9.1.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${context}/common/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${context}/common/js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${context}/common/js/sb-admin-2.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#pw").keydown(function (key){
				if(key.keyCode == 13){
					ajaxLoginCheck();
				}

			});
		});

		function ajaxLoginCheck(){
			var id = $("#id").val();
			var pw = $("#pw").val();

			var param = {};

			param["id"] = id;
			param["pw"] = pw;

			$.ajax({
				url:"${context}/user/ajaxLoginCheck",
				contentType:"application/json",
				dataType:"json",
				data:param,
				success:function(result){
					if(result['loginYn'] == 'success'){
						alert("로그인에 성공하였습니다.");
						$("#loginFrm").submit();
					}else{
						alert('로그인에 실패하셨습니다.');
						$("#id").val('');
						$("#pw").val('');
					}
				}
			});
		}


	</script>
</head>

<body>
	<!-- content start -->
	<div id="jumbotron" class="container">
		<div class="jumbotron jumbotron-info" style="background-color: lightgray;">
			<h1><font color="black"><strong>LOGIN</strong>&nbsp;<span class="glyphicon glyphicon glyphicon-pencil"></span></font></h1>
			<p>HS STATIONERY에 오신것을 진심으로 환영합니다.</p>
		</div>
	</div>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default"  style="margin-bottom: 57%;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form action="${context}/user/login" method="post" role="form" id="loginFrm">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="ID" id="id" name="id" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" id="pw" name="pw" type="password">
                                </div>
                                <div class="form-group">
                                	<span style="float: left;"><a href="${context}/user/idFind">ID찾기</a>|<a href="${context}/user/pwFind">PW찾기</a></span>
                                	<span style="float: right;"><a href="/user/createUser">회원가입</a></span><br>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" class="btn btn-lg btn-success btn-block" onclick="ajaxLoginCheck();">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!-- content end -->

</body>
</html>
