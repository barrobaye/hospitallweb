<%--
  Created by IntelliJ IDEA.
  User: barro
  Date: 17-02-2023
  Time: 02:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap/dist/css/bootstrap.css" />
    <link  rel="stylesheet" type="text/css" href="css/mycss.css"/>
</head>
<body >
<div class="container-fluid">
    <h1>Dashboard JAva Servlet</h1>
    <div style="width: 100%; height: 182px;"></div>
    <div class="d-flex justify-content-around">
    <div class="row d-flex justify-content-around shadow-lg p-3 mb-5 bg-white rounded card border-primary mb-3" style="max-width: 18rem;">
        <button class="bntmd card-header" ><a  href="${pageContext.request.contextPath}/medecin" >Médecin </a></button>
        <div class="card-body text-primary">
            <h5 class="card-title">Liste Medecin</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
    </div>
    <div class="card border-secondary mb-3 shadow-lg p-3 mb-5 bg-white rounded"  style="max-width: 18rem;">
        <button class="bntsev card-header" ><a  href="${pageContext.request.contextPath}/service" >Service </a></button>
        <div class="card-body text-secondary">
            <h5 class="card-title"> List Services</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
    </div>
    <div class="card border-success mb-3 shadow-lg p-3 mb-5 bg-white rounded" style="max-width: 18rem;">
        <button class="card-header bntsp"><a  href="${pageContext.request.contextPath}/specialite" >Spécialité </a></button>
        <div class="card-body text-success">
            <h5 class="card-title">List Specialité</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
    </div>
    </div>
</div>
</body>
</html>
<style>

</style>
