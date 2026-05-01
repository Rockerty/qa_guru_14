# Проект автоматизации тестов для сайта "Мир магнитов"

## О сайте  
<p align="center">
<img width="16%" title="IntelliJ IDEA" src="images/icons/logoMirMagnitov.svg">
<br>
<img width="16%" title="IntelliJ IDEA" src="images/icons/logoMirMagnitov2.svg">
</p>

[Интернет магазин "Мир магнитов](https://mirmagnitov.ru/ "Перейти на сайт \"Мир магнитов\"") — лидер магнитной продукции в России.

# Тестовые наборы
1. Навигация в каталоге
   1. Навигация по каталогу: второй уровень вложенности
   2. Навигация по каталогу: третий уровень вложенности
2. Главная страница
   1. Главная страница: телефонный номер
   2. Главная страница: текущий город
   3. Главная страница: раздел 'Доставка и оплата'
   4. Главная страница: раздел 'Контакты'
   5. Главная страница: раздел 'Помощь и советы'
   6. Главная страница: раздел 'Купить оптом'

## Cтек технологий

<p align="center">

[<img width="6%" title="IntelliJ IDEA" src="images/icons/Intelij_IDEA.svg">](https://www.jetbrains.com/idea/)
[<img width="6%" title="Java" src="images/icons/Java.svg">](https://www.java.com/)
[<img width="6%" title="Selenide" src="images/icons/Selenide.svg">](https://selenide.org/)
[<img width="6%" title="Selenoid" src="images/icons/Selenoid.svg">](https://aerokube.com/selenoid/)
[<img width="6%" title="Allure Report" src="images/icons/Allure_Report.svg">](https://qameta.io/allure-report/)
[<img width="6%" title="Gradle" src="images/icons/Gradle.svg">](https://gradle.org/)
[<img width="6%" title="JUnit5" src="images/icons/JUnit5.svg">](https://junit.org/junit5/)
[<img width="6%" title="GitHub" src="images/icons/GitHub.svg">](https://github.com/)
[<img width="6%" title="Jenkins" src="images/icons/Jenkins.svg">](https://www.jenkins.io/)
[<img width="6%" title="Telegram" src="images/icons/Telegram.svg">](https://telegram.org/)

</p>

## Запуск автотестов

## __Локальный запуск__

> ./gradlew clean test "-DbaseUrl=https://mirmagnitov.ru" "-Dbrowser=chrome" "-DbrowserSize=1920x1080" "-DisHeadless=false"

## __Терминал__ 
> ./gradlew clean test "-DbaseUrl=https://mirmagnitov.ru" "-DselenoidRemoteURL=https://user1:1234@selenoid.autotests.cloud/wd/hub" "-Dbrowser=chrome" "-DbrowserSize=1920x1080" "-DisHeadless=false" "-DbrowserVersion=128.0"  

## [__Jenkins__](https://jenkins.autotests.cloud/view/java_students/job/C40-Rockerty-Mir-Magnotov/) с параметрами

Перед запуском сборки в Jenkins необходимо указать параметры:

1. Адрес тестируемого сайта (`BaseURL`).
2. Адрес удаленной среды, в которой будет запущен браузер (`SelenoidRemoteURL`).
3. Браузер, в котором будут выполняться автотесты (`Browser`).
4. Версия браузера для запуска автотестов (`BrowserVersion`).
5. Размер окна браузера (`BrowserSize`).

## Пример автоматического отчета Allure

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/Allure_screen.png" width="850">  
</p>  

## Уведомления в Telegram

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/TG_report_csreen.png" width="850">  
</p> 

## Видео выполнения теста
<p align="center">
<img title="Selenoid Video" src="images/videos/4c407e132599fa4dd55a5d64d4811531.gif" width="550" height="350"  alt="video">   
</p>