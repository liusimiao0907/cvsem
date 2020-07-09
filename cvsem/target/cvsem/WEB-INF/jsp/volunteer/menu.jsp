<%--
  Created by IntelliJ IDEA.
  User: 刘思淼
  Date: 2020/7/7
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/oldperson/showOldperson">老人管理<span class="badge pull-right">8</span></a></li>
        <li><a href="${pageContext.request.contextPath}/volunteer/showVolunteer">义工管理<span class="badge pull-right">59</span></a></li>
        <li><a href="${pageContext.request.contextPath}/employee/showEmployee">工作人员管理<span class="badge pull-right">10</span></a></li>
        <li><a href="${pageContext.request.contextPath}/webcam/showWebcam">摄像头管理<sapn class=glyphicon glyphicon-repeat pull-right /></a></li>
        <li><a href="${pageContext.request.contextPath}/user/showDetail">个人用户管理<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>
