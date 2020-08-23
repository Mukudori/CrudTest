<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Редактирование категории</title>
    <style>
        body { margin: 0; }
        #sidebar, #content_frame { position: absolute; }
        #sidebar, #content_frame  { overflow: auto; padding: 10px; }
        #header {
            height: 70px; /* Высота слоя */
            background: #FEDFC0; border-bottom: 2px solid #7B5427;
        }
        #header h1 { padding: 20px; margin: 0; }
        #sidebar {
            width: 150px; background: #ECF5E4; border-right: 1px solid #231F20;
            top: 82px; /* Расстояние от верхнего края */
            bottom: 0; /* Расстояние снизу  */
        }
        #content_frame {
            top: 82px; /* Расстояние от верхнего края */
            left: 170px; /* Расстояние от левого края */
            bottom: 0; right: 0;
        }

        ul.hr {
            margin-left: 30%; /* Отступ слева */
            width: 40%; /* Ширина слоя */

            padding: 4px; /* Значение полей */
        }
        ul.hr li {
            display: inline; /* Отображать как строчный элемент */

            border: 1px solid #000; /* Рамка вокруг текста */
            padding: 3px; /* Поля вокруг текста */
        }

        ul.wr{
            line-height: 5;
            padding: 4px; /* Значение полей */
            list-style-type: none; /* Убираем маркеры */
        }

        ul.wr a {
            margin: 5;
            margin-right: 5px; /* Отступ слева */
            border: 1px solid #000; /* Рамка вокруг текста */
            padding: 3px; /* Поля вокруг текста */
        }

        input.big{
            width: 50%;
            hight
        }


    </style>


    <c:if test="${empty banenr.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty banner.name}">
        <title>Edit</title>
    </c:if>

</head>
<body>
<div id="header">
    <br>
    <ul class="hr">
        <li><a href="/">Баннеры</a></li>
        <li><a href="/categories">Категории</a></li>
        <li><a href="/requests">Запросы</a></li>
    </ul>

</div>
<div id="sidebar">

    <ul class="wr" >

        <li> <a href="/allCategories">Все категории</a></li>

    </ul>
</div>
<div id="content_frame">
    <h2>Редактирование категории</h2>
    <c:if test="${empty category.name}">
        <c:url value="/add" var="var"/>

    </c:if>
    <c:if test="${!empty category.name}">
        <c:url value="/edit" var="var"/>

    </c:if>
    <form:form action="${var}" method="POST">

        <ul class="wr">
            <c:if test="${empty category.name}">
                <input type="hidden" name="id" value="0">

            </c:if>
            <c:if test="${!empty category.name}">
                <input type="hidden" name="id" value="${category.id}">
            </c:if>
            <li> <label for="name">Название</label> </li>
            <li><input type="text" name="name" id="name" value="${category.name}"></li>
            <li><label for="req_name">Req Name</label> </li>
            <li> <input type="text" name="req_name" id="req_name" value="${category.req_name}"></li>


            <c:if test="${empty category.name}">
                <li><input type="submit" value="Добавить категорию"></li>
            </c:if>
            <c:if test="${!empty category.name}">
                <li>  <input type="submit" value="Сохранить изменения"></li>
            </c:if>

        </ul>
    </form:form>

</div>
</body>