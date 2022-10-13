<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 10/12/2022
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <section class="row">
        <c:forEach items="${products}" var="p">
<%--            <c:url var="updateLink" value="/restaurant/products/edit/">--%>
<%--                <c:param name="productId" value="${p.id}"></c:param>--%>
<%--            </c:url>--%>
            <div class="col-4">
                <div class="card">
                    <img src="${p.image}" class="card-img-top img-fluid" width="50" height="100">
                    <div class="card-body">
                        <h5 class="card-title">${p.name}</h5>
                        <p class="card-text">
                            <fmt:formatNumber value="${p.price}" maxFractionDigits="3" type="number"/> VND
                        </p>
                        <a href="<c:url value="/products/${p.id}"/> " class="btn btn-primary">Xem chi tiết</a>
                        <a href="${updateLink}" class="btn btn-primary">Update</a>
                        <a href="javascript:;" class="btn btn-danger" onclick="deleteProduct(${p.id})">Xóa</a>
                        <a href="#" class="btn btn-primary" onclick="addToCart(${p.id},'${p.name}',${p.price})">Đặt hàng</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </section>
</div>
