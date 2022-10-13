<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 10/11/2022
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <form:form method="post" action="/restaurant/products/createOrEdit" modelAttribute="product">
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
            <label for="name">Ten san pham</label>
            <form:errors path="name" element="div" cssClass="invalid-feedback"></form:errors>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="price" />
            <label for="name">Gia san pham</label>
            <form:errors path="price" element="div" cssClass="invalid-feedback"></form:errors>
        </div>
        <div>
            <br>
            <form:button type="submit"
                         class="btn btn-primary btn-lg btn-block">Submit</form:button>
        </div>
    </form:form>
</div>
