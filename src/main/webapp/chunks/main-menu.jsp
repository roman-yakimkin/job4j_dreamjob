<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link" href='<c:url value="/posts.do" />' >Вакансии</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value="/candidates.do" />'>Кандидаты</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value="/edit.do?entity=post" />'>Добавить вакансию</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value="/edit.do?entity=candidate" />'>Добавить кандидата</a>
    </li>
    <li class="nav-item">
        <c:if test="${user == null}">
            <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Войти</a>
        </c:if>
        <c:if test="${user != null}">
            <a class="nav-link" href="<c:url value="/auth.do?action=logout" />"> <c:out value="${user.name}"/> | Выйти</a>
        </c:if>
    </li>
</ul>

