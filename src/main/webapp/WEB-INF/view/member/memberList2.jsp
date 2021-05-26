<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
window.onload = function(){
	 var grid = new tui.Grid({
      el: document.getElementById('grid'),
      //data: gridData,
      scrollX: false,
      scrollY: false,
      columns: [
        {
          header: 'id',
          name: '아이디'
        },
        {
          header: 'email',
          name: '이메일'
        },
        {
          header: 'name',
          name: '이름'
        },
        {
          header: 'registerDate',
          name: '가입일'
        }
      ]
    });
	$.ajax({
		url:"/members",
		method:"POST",
		dataType:"JSON",
		success: function(result){
				console.dir(result);
				grid.resetData(result);
		}
	});
};
  </script>

<title>회원 조회</title>
</head>
<body>
	<form:form modelAttribute="cmd">
		<p>
			<label>from: <form:input path="from"/></label><form:errors path="from"/>~
			<label>to: <form:input path="to"/></label><form:errors path="to"/>
			<input type="submit" value="조회">
		</p>
	</form:form>
	<c:if test="${! empty members }">
		<table>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="mem" items="${members }">
			<tr>
				<td>${mem.id }</td>
				<td><a href="<c:url value="/members/${mem.id }"/>">${mem.email }</a></td>
				<td>${mem.name }</td>
				<td><tf:formatDateTime value="${mem.registerDateTime }" pattern="yyyy-MM-dd" /></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<div id="grid"></div>
</body>
</html>