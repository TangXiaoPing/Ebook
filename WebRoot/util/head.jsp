<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<a id="head_img" href="${pageContext.request.contextPath}/client/index.jsp">
	<img id="head_img" alt="网上书城" src="${pageContext.request.contextPath}/img/taobao.png"/>
</a>
<div id="head" >
	<c:choose>
         	<c:when test="${sessionScope.userInfo.user.username!=null}">
           <span>欢迎你,<a href="${pageContext.request.contextPath}/client/userInfo.jsp">${sessionScope.userInfo.user.username}</a></span>
         </c:when>
          <c:otherwise>
			<a href="${pageContext.request.contextPath}/client/login.jsp">你还没登陆,请点击登陆!</a>
		</c:otherwise>
        </c:choose>
	<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
	<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
	<a href="${pageContext.request.contextPath}/getAllBook.action">主页</a>
</div>