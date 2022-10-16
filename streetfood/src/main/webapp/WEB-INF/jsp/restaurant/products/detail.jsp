<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<div class="row">
    <div class="col-md-5">
        <img src="${product.image}" alt="${product.name}" class="img-fluid" />
    </div>
    <div class="col-md-7">
        <h1>${product.name}</h1>
        <h3>${product.price} VND</h3>
    </div>
</div>