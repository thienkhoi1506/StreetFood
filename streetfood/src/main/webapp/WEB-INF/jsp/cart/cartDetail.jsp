<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 10/14/2022
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cart</h2>
<hr/>
<table>
    <tr>
        <td>No.</td>
        <td>Name</td>
        <td>Quantity</td>
        <td>Price</td>
        <td></td>
    </tr>
    <c:set var="No" value="1"></c:set>
    <c:forEach var="item" items="${cart}">
        <form:form action="/cart/update" method="post">
            <tr>
                <td>${No }</td>
                <td>${item.productName}</td>
                <td>
                    <input type="hidden" name="productId" value="${item.productId}">
                    <input type="number" value="${item.quantity}" name="quantity"
                           onblur="this.form.submit()"
                    >
                </td>
                <td>${item.price}</td>
                <td>
                    <a href="/cart/remove/${item.productId}">Remove</a>
                </td>
            </tr>
        </form:form>
        <c:set var="No" value="${No + 1}"></c:set>
    </c:forEach>
</table>
<a href="/cart/checkout">Thanh toán</a>
</body>
</html>
