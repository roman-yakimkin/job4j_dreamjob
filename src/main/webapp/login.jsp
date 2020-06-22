<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<div class="container pt-3">
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
    </script>
    <div class="row">
        <c:if test="${message != null}">
            <div class="alert alert-dark" role="alert">
                <c:out value="${message}" />
            </div>
        </c:if>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Авторизация
            </div>
            <div class="card-body">
                <form action="<c:url value="/auth.do" />" method="post">
                    <div class="form-group">
                        <label for="name">e-mail</label>
                        <input type="text" id="name" class="form-control" name="email" title="Имя пользователя">
                    </div>
                    <div class="form-group">
                        <label for="password">Пароль</label>
                        <input type="text" id="password" class="form-control" name="password" title="Пароль">
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validate();">Войти</button> или <a href="<c:url value="/reg.do" />">зарегистрироваться</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>