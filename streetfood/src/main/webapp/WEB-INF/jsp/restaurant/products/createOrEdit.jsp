<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
  <c:url value="/restaurant/products/saveProduct" var="action"></c:url>
  <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <form:hidden path="id"/>
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
    <div class="form-floating">
      <form:select path="categoryByCategoryId" class="form-select" id="cate" name="cate">
        <c:forEach items="${categories}" var="c">
          <option value="${c.id}">${c.name}</option>
        </c:forEach>
      </form:select>
      <label for="cate" class="form-label">Danh muc san pham</label>
    </div>
    <div>
      <br>
<%--      <form:input path="img" id="imgId" type="file" cssClass="form-control"></form:input>--%>
    </div>
    <div>
      <br>
      <form:button type="submit"
                   class="btn btn-primary btn-lg btn-block">Submit</form:button>
    </div>
  </form:form>
</div>