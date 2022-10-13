<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<h1>List Product: </h1>
<div class="row">
    <c:forEach items="${product}" var="p">
        <div class="col-4">
            <div class="card">
                <img src="${p.image}" class="card-img-top img-fluid" width="50" height="100">
                <div class="card-body">
                    <h5 class="card-title">${p.name}</h5>
                    <p class="card-text">
                        <fmt:formatNumber value="${p.price}" maxFractionDigits="3" type="number"/> VND
                    </p>
                    <a href="<c:url value="/product-view/${p.id}"/> " class="btn btn-primary">Xem chi tiết</a>
                    <a href="<c:url value="/product-update/${p.id}"/> " class="btn btn-primary">Update</a>
                    <a href="<c:url value="/productDelete/${p.id}"/> " class="btn btn-danger">Xóa</a>
                    <a href="#" class="btn btn-primary" onclick="addToCart(${p.id},'${p.name}',${p.price})">Đặt hàng</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
