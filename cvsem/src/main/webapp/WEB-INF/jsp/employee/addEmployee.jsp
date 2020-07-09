<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="../employee/top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			<jsp:include page="../employee/menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">添加工作人员信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/employee/addEmployee" id="editfrom" method="post">
							<div class="form-group ">
								<label for="inputEmail3" class="col-sm-2 control-label" >ID</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="inputEmail3" name="id" placeholder="请输入ID"
									<c:if test='${employee!=null}'>
										   value="${employee.id}"
									</c:if>>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPassword3" name="username" placeholder="请输入姓名" value="${employee.username}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-10">
									<label class="checkbox-inline">
										<input type="radio" name="gender" value="male" checked>男
									</label>
									<label class="checkbox-inline">
										<input type="radio" name="gender" value="fem">女
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">手机号</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="phone" placeholder="请输入手机号" value="${employee.phone}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
								<div class="col-sm-10">
									<input type="date" value="<fmt:formatDate value="${employee.birthday}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthday"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label" name="hire_date">入职时间</label>
								<div class="col-sm-10">
									<input type="date" value="<fmt:formatDate value="${employee.hireDate}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="hireDate"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label" name="resign_date">注册时间</label>
								<div class="col-sm-10">
									<input type="date" value="<fmt:formatDate value="${employee.resignDate}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="resignDate"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">描述</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="description" placeholder="请输入描述" value="${employee.description}">
								</div>
							</div>
							<div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default" type="reset">重置</button>
							</div>
						</form>
				    </div>
				    
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
	<div class="row">
		<div class="col-md-12"></div>
	</div>
	</div>
</body>
	<script type="text/javascript">
		$("#nav li:nth-child(3)").addClass("active")
	</script>
</html>