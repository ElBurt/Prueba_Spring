<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="createinventory.heading"/></h1>
<p><fmt:message key="greeting"/> <c:out value="${ahora1}"/></p>
    <br>
<form:form method="post" commandName="createInventory">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">ProductRef:</td>
        <td width="20%">
        <form:select path="productRef">
			<form:option value="0" label="...." />
			<form:options items="${products}" itemLabel="description" itemValue="id"/>
        </form:select>
        </td>
        <td width="60%">
          <form:errors path="productRef" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Quantity:</td>
        <td width="20%">
          <form:input path="quantity"/>
        </td>
        <td width="60%">
          <form:errors path="quantity" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>