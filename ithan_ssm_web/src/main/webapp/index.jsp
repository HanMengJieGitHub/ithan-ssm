<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<jsp:forward page="/pages/main.jsp"></jsp:forward>

<a href="${pageContext.request.contextPath}/product/findAll.do">发送链接</a>
${pageContext.request.contextPath}
</body>
</html>
