# fin_statistic

Приложение парсит JSON с биржи Poloniex и заливает данные токенов в БД (MySQL).

* В репозитории выложен батник StartApp.bat, который запускает процесс заливки.
* Так же выложены дынные для локально БД. Если необходимо лить в удаленную БД меняем под себя. 

В планах доработать:

1) Парсинг Json 
    - с других Бирж для анализа арбитража.
    - удачи добычи блока монет с пулов и добытых монет майнером

2) Вывод статистики на веб морду с авторизацией и прочими плюхами
