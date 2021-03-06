<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Баннеры</title>
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

    <ul class="wr" >
        <li><form action="/findByBannerName">
            <input type="text" name="findName" value="">
            <input type="submit" value="Поиск по имени">
        </form></li>
        <li> <a href="/allBanners">Все баннеры</a></li>
        <li> <a href="/addBanner">Новый баннер</a></li>

    </ul>
</div>
<div id="content">
    <h2>Баннеры</h2>

    <table>
        <tr>
            <th>id</th>
            <th>Название</th>
            <th>Категория</th>
            <th>Стоимость</th>
            <th>deleted</th>
        </tr>
        <c:forEach var="banner" items="${bannersList}">
            <tr>
                <td>${banner.id}</td>
                <td>${banner.name}</td>
                <td>${banner.category.name}</td>
                <td>${banner.price}</td>
                <td>${banner.deleted}</td>
                <td>
                    <a href="/bannerInfo/${banner.id}">Подробнее</a>
                    <a href="/editBanner/${banner.id}">Редактировать</a>
                    <a href="/deleteBanner/${banner.id}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>