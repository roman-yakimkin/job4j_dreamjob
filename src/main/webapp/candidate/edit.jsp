<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    if (request.getHeader("referer") == null) {
        response.sendRedirect(request.getContextPath() + "/index.do");
    }
%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <title>Работа мечты</title>
</head>
<body>
<script>
    function validate() {
        let elements = $("#form-reg .form-control");
        for (let i = 0; i < elements.length; i++) {
            if (elements[i].value === "") {
                alert("Поле \"" + elements[i].title + "\" должно быть заполнено");
                return false;
            }
        }
        return true;
    }
    function addCities(currentCity) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dreamjob/cities.do',
            contentType: "application/json",
            dataType: 'json',
            processData: false,
            success: function(data) {
                $.each(data, function(id, name){
                    let selected = (id == currentCity) ? " selected " : " ";
                    $("#city").append("<option" + selected + "value='" + id + "'>" + name + "</option>");
                })
            },
            error: function(jqXhr, textStatus, errorThrown) {
                console.log(errorThrown);
            }
        });
    }
    $(document).ready(function(){
       addCities(<c:out value="${candidate.cityId}" />);
    });
</script>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <c:if test="${id == null}">
                    Новый кандидат
                </c:if>
                <c:if test="${id != null}">
                    Редактирование кандидата
                </c:if>
            </div>
            <div class="card-body">
                <form action="<c:url value="/candidates.do?id=${candidate.id}" />" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" name="name" class="form-control" title="Имя" value="<c:out value="${candidate.name}" />">
                    </div>
                    <div class="form-group">
                        <label>Город</label>
                        <select name="city" id="city" class="form-control">

                        </select>
                    </div>
                    <div class="form-group">
                        <label>Фотография</label>
                        <select name="photo" class="form-control" title="Имя">
                        <c:forEach var="photo" items="${photos}">
                            <option
                            <c:if test="${candidate.photoId == photo.id}">
                                selected
                            </c:if>
                             value="<c:out value="${photo.id}" />"><c:out value="${photo.name}"/></option>
                        </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>