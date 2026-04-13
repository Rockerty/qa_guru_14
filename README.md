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
<img width="6%" title="IntelliJ IDEA" src="images/icons/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/icons/Java.svg">
<img width="6%" title="Selenide" src="images/icons/Selenide.svg">
<img width="6%" title="Selenoid" src="images/icons/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/icons/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/icons/Gradle.svg">
<img width="6%" title="JUnit5" src="images/icons/JUnit5.svg">
<img width="6%" title="GitHub" src="images/icons/GitHub.svg">
<img width="6%" title="Jenkins" src="images/icons/Jenkins.svg">
<img width="6%" title="Telegram" src="images/icons/Telegram.svg">
</p>

## Запуск автотестов

## __Терминал__ 
> ./gradlew clean test "-DbaseUrl=https://mirmagnitov.ru" "-DselenoidRemoteURL=https://user1:1234@selenoid.autotests.cloud/wd/hub" "-Dbrowser=chrome" "-DbrowserSize=1920x1080" "-DisHeadless=false" "-DbrowserVersion=128.0"  

## [__Jenkins__](https://jenkins.autotests.cloud/view/java_students/job/C40-Rockerty-Mir-Magnotov/) с параметрами

1. BaseURL
2. SelenoidRemoteURL
3. Browser
4. BrowserVersion
5. BrowserSize

## Пример автоматического отчета Allure

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/Allure_screen.png" width="850">  
</p>  

## Уведомления в Telegram

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/TG_report_csreen.png" width="850">  
</p> 