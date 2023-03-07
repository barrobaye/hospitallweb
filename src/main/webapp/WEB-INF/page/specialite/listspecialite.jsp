<%--<jsp:useBean id="specialite" scope="request" type=""/>--%>
<%--
  Created by IntelliJ IDEA.
  User: barro
  Date: 17-02-2023
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@  page  isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Specialité </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mycss.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="<%=request.getContextPath()%>/bootstrap/dist/css/bootstrap.css" />

</head>
<body>
<h1>Liste des Specialités</h1>

<button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-push="add">Ajouter</button>
<table class="table table-success table-striped">
    <thead>
    <tr>
        <th scope="col">Numero</th>
        <th scope="col">Specialite</th>
        <th scope="col">Service</th>
        <th scope="col">Action</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach items="${requestScope.specialite}" var="specialites">
    <tr>
        <td>${specialites.id}</td>
        <td>${specialites.libelle}</td>
        <td>${specialites.service.libelle}</td>
        <td> <a data-toggle="modal" data-target="#exampleModal" data-push="edit"  href="${pageContext.request.contextPath}/specialite/update?id=${specialites.id}" class="btn btn-warning">modifier</a>
            <a href="${pageContext.request.contextPath}/specialite?action=delete&id=${specialites.id}" class="btn btn-danger">supprimer</a></td>
    </tr>
    </c:forEach >
    </tbody>
</table>

</table>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group">
                        <label for="libelle"  class="col-form-label">libelle</label>
                        <input type="text" name="libelle" class="form-control" id="libelle">
                    </div>
                    <div class="form-group">
                        <label for="service" class="col-form-label">service</label>
                        <select name="service" id="serviceId" class="form-control">
                            <option value=""> selectionnez le service</option>
                            <c:forEach items="${requestScope.services}" var="service">
                                <option value="${service.id}"> ${service.libelle}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit"  class="btn btn-primary">Enregistrer</button>
                    <input type="hidden" name="specialiteId" value="" id="specialiteId">
                    <input type="hidden" name="action" value="" id="action">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
<!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
<script src="jquery/dist/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="application/javascript">
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
       var recipient = button.data('push') // Extract info from data-* attributes
// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Specialité' + recipient)
      //  modal.find('.modal-body input').val(recipient)
        if (recipient === 'add'){
           // console.log('add');
            $('#action').val("add")
            $('#specialiteId').val("")
            $('#libelle').val("")
            $('#serviceId').val("")
        }else {
         id = button.closest("tr").find("td:eq(0)").text()
            $('action').val("edit")
            $.ajax({
                url:"/hospitallweb_war/specialite",
                data:{specialiteId:id,action:"edit"},
                methode:"GET",
                dataType:"json",
                success:function (data) {
                    $('#specialiteId').val(data.id)
                    $('#libelle').val(data.libelle)
                    $('#serviceId').val(data.service)
                }
            })
           // console.log('edit');
        }
    })
</script>
</html>
