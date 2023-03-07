<%--
  Created by IntelliJ IDEA.
  User: barro
  Date: 19-02-2023
  Time: 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Service</title>
    <link href="<%=request.getContextPath()%>/css/mycss.css"/>
    <link href="<%=request.getContextPath()%>/bootstrap/dist/css/bootstrap.css" />

</head>
<body>
<table class="table table-success table-striped">
    <thead>
    <tr>
        <th scope="col">Numero</th>
        <th scope="col">Specialite</th>
        <th scope="col">Action</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach items="${requestScope.specialite}" var="specialites">
    <tr>
        <td>${specialites.id}</td>
        <td>${specialites.libelle}</td>
        <td> <a href="${pageContext.request.contextPath}/specialite/update?id=${specialite.id}" class="btn btn-warning">modifier</a>
            <a href="${pageContext.request.contextPath}/specialite/remove?id=${specialite.id}" class="btn btn-danger">supprimer</a></td>
    </tr>
    </c:forEach >

</body>
</html>
