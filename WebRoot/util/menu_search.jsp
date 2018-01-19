<%-- 
	网页头部信息
	@author: luoxn28
	@date: 2016.5.15
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div id="book_menu">
	<a href="${pageContext.request.contextPath}
		/getBookType.action?bookTypeName=修仙小说">修仙小说</a>
	<a href="${pageContext.request.contextPath}
		/getBookType.action?bookTypeName=玄幻小说">玄幻小说</a>
	<a href="${pageContext.request.contextPath}
		/getBookType.action?bookTypeName=武侠小说">武侠小说</a>
	<a href="${pageContext.request.contextPath}
		/getAllBook.action">全部商品目录</a>
</div>

<div id="book_search">
	<form action="${pageContext.request.contextPath}/getBookByName.action" method="get">
		Search<input type="text" name="bookName" value="请输入书名"/>
		<input type="submit" value="搜索"/>
	</form>
</div>