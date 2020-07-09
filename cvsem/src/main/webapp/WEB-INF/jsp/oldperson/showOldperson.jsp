<%--
  Created by IntelliJ IDEA.
  User: 刘思淼
  Date: 2020/7/8
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>老年人信息管理</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">老人管理</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="${pageContext.request.contextPath}/oldperson/selectOldperson" id="form1" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
                                <span class="input-group-addon btn" id="sub">搜索</span>
                            </div>
                        </form>
                        <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='${pageContext.request.contextPath}/oldperson/addOldperson'">
                            添加老人信息
                            <sapn class="glyphicon glyphicon-plus"/>
                        </button>

                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>身份证号</th>
                        <th>出生日期</th>
                        <th>入院时间</th>
                        <th>出院时间</th>
                        <th>房间号</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${oldpersonList}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.username}</td>
                            <td>${item.gender}</td>
                            <td>${item.phone}</td>
                            <td>${item.idCard}</td>
                            <td><fmt:formatDate value="${item.birthday}" dateStyle="medium" /></td>
                            <td><fmt:formatDate value="${item.checkinDate}" dateStyle="medium" /></td>
                            <td><fmt:formatDate value="${item.checkoutDate}" dateStyle="medium" /></td>
                            <td>${item.roomNumber}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info" onClick="location.href='${pageContext.request.contextPath}/oldperson/editOldperson?id=${item.id}'">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='${pageContext.request.contextPath}/oldperson/removeOldperson?id=${item.id}'">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pagingVO != null}">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>
                                <li class="active"><a href="">${pagingVO.curentPageNo}</a></li>
                                <c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
                                    <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">
                                    <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">
                                    <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">
                                    <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>
                                </c:if>
                                <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>
                            </ul>
                        </nav>
                    </c:if>
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
    $("#nav li:nth-child(2)").addClass("active");

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    };

    $("#sub").click(function () {
        $("#form1").submit();
    });

    <c:if test="${pagingVO != null}">
    if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
        $(".pagination li:last-child").addClass("disabled")
    };

    if (${pagingVO.curentPageNo} == ${1}) {
        $(".pagination li:nth-child(1)").addClass("disabled")
    };
    </c:if>
</script>
</html>
