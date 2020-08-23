<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Запросы</title>
    <style>
        body { margin: 0; }
        #sidebar, #content { position: absolute; }
        #sidebar, #content { overflow: auto; padding: 10px; }
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
        #content {
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


    </style>
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

</div>
<div id="content">
    <h2>Запросы</h2>

    <table>
        <tr>
            <th>id</th>
            <th>IP Адрес</th>
            <th>Клиент</th>
            <th>Баннер</th>
            <th>Время</th>
        </tr>
        <c:forEach var="request" items="${requestsList}">
            <tr>
                <td>${request.id}</td>
                <td>${request.ip_address}</td>
                <td>${request.user_agent}</td>
                <td>${request.banner.name}</td>
                <td>${request.date}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>