<%-- 
	商品页面
	@author: luoxn28
	@date: 2016.5.19
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品页面 - bookstore</title>
	<script type="text/javascript">
		$(function(){
			$("#updatePhone").click(function(){
				var	newPhone=prompt("请输入你的新电话:","");
				if(newPhone!=null){
					$.ajax({
						url:"${pageContext.request.contextPath}/updateUser.action?newPhone="+newPhone,
						type:"post",
						dataType:"json",
						success:function(data){
							alert(data.message);
							if(data.status==1){
								$("#sphone").text(newPhone);
							}
						}
					})
				}
			})
			$("#updatePwd").click(function(){
				var	newPwd=prompt("请输入你的新密码:","");
				if(newPwd!=null){
					$.ajax({
						url:"${pageContext.request.contextPath}/updateUser.action?newPwd="+newPwd,
						type:"post",
						dataType:"json",
						success:function(data){
							alert(data.message);
							if(data.status==1){
								$("#spwd").text(newPwd);
							}
						}
					})
				}
			})
		})
	</script>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>

		账户名:${userInfo.user.username} <br/>
		电&nbsp;话:<span id="sphone">${userInfo.user.phone}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="updatePhone">点击修改电话</button><br/>
		密&nbsp;码:<span id="spwd">${userInfo.user.password}</span> &nbsp;&nbsp;&nbsp;&nbsp;<button id="updatePwd">点击修改密码</button><br/>
</body>
</html>