<h2>Тестовое  CRUD-приложение</h2>
При написании использовались:
<ul> 
    <li>Maven</li> 
    <li>Tomcat</li>  
    <li>Spring</li>
    <li>Hibernate </li>
    <li>MySQL</li>   
</ul>

***
<h3>Краткое описание</h3>

![banners.jsp.png](/readme-resources/banners.jsp.png)

Начальная страница отображает список баннеров, не помеченных на удаление. При переходе на "все банеры" выводятся и помеченные на удаление. Если повторно удалить помеченную запись, то она удалится и из бд. 
<br>
При редактировании или добавлении банера категория выбирается через выпадающий список. 

![bannerEdit.png](/readme-resources/bannerEdit.png)

Поиск по имени проходит с переводом обеих строк в нижний регистр. 
Страница категорий работает аналогично. 
<br>
При переходе по ссылке дополнительной информации о баннере, данные о запросе заносятся в таблицу t_reqest. 

Схема БД выглядит следующим образом: 
![bdScheme.png](/readme-resources/bdScheme.png)

***




Загрузка базы данных:
<code>
<br>
mysql> CREATE DATABASE jarsoft;  <br>
mysql>  SELECT jarsoft; <br>
mysql>  SOURCE "путь к .sql"</code>  

Файл загрузки тестовой бд лежит в "/readme-resources/jarsoft.sql"
******
У MySQL часто встречается проблема синхронизации часовых поясов.
Для решения этой проблемы нужно в файле db.properties к строчке "jdbc.url" добавит:  

<code> ?serverTimezone=Asia/Novosibirsk&useSSL=false</code>

или

<code> ?serverTimezone=UTC&useSSL=false</code>

Так же, стоит настроить username и password.
****
Для запуска сервера использовался плагин Tomcat Server, с версией Tomcat - 9.0.37. 

