<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %> 

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.description}"/> <i>€<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    <br>
    <h3>Inventories</h3>
    <c:forEach items="${model.inventories}" var="inv">
      <c:out value="${inv.productRef.description}"/><i>: <c:out value="${inv.quantity}"/></i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <a href="<c:url value="createproduct.htm"/>">Create Product</a>
    <a href="<c:url value="createinventory.htm"/>">Create Inventory</a>
    <br>
  </body>
</html>