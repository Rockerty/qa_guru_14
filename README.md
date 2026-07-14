# Проект автоматизации тестов для сайта [«Мир магнитов»](https://mirmagnitov.ru/)

## О сайте  
<p align="center">
<img width="16%" title="IntelliJ IDEA" src="images/icons/logoMirMagnitov.svg">
<br>
<img width="16%" title="IntelliJ IDEA" src="images/icons/logoMirMagnitov2.svg">
</p>

[Интернет магазин "Мир магнитов](https://mirmagnitov.ru/ "Перейти на сайт \"Мир магнитов\"") — лидер магнитной продукции в России.

## Содержание

* <a href="#tools">Стек технологий</a>
* <a href="#cases">Тестовые наборы</a>
* <a href="#jenkins">Запуск в Jenkins</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#allure">Allure Report</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#telegram">Уведомления в Telegram</a>
* <a href="#video">Видео выполнения тестов</a>

<a id="cases"></a>

# Тестовые наборы

## UI автотесты

1. Навигация в каталоге
   1. Навигация по каталогу: второй уровень вложенности
   2. Навигация по каталогу: третий уровень вложенности

2. Главная страница
   1. Проверка телефонного номера на главной странице
   2. Проверка отображения иконок социальных сетей Max и WhatsApp
   3. Переход в раздел "Доставка и оплата"
   4. Переход в раздел "Контакты"
   5. Переход в раздел "FAQ"
   6. Переход в раздел "Акции и скидки"
   7. Переход на сайт Ozon
   8. Переход на сайт Wildberries

## API автотесты

1. Корзина
   1. Добавление корректного товара в корзину
   2. Проверка количества товара, productId, счетчика корзины и счетчика в header
   3. Проверка добавления некорректного товара в корзину
   4. Открытие корзины с добавленным товаром
   5. Проверка наличия productId товара в HTML корзины
   6. Удаление одного товара из корзины
   7. Очистка корзины после добавления нескольких товаров

2. Избранное
   1. Добавление товара в избранное
   2. Проверка productId добавленного товара в списке избранного
   3. Удаление товара из избранного
   4. Очистка списка избранного

3. Сессия
   1. Получение sessionId
   2. Получение uid
   3. Получение location
   4. Получение sessid
   5. Использование полученных данных для выполнения API-запросов к корзине и избранному

## Ручные тест-кейсы

1. Фильтры
   1. Проверка отображения списка фильтров
   2. Проверка фильтрации по цене
   3. Проверка фильтрации по мощности сцепления

2. Регистрация
   1. Проверка регистрации пользователя
   2. Проверка регистрации по номеру телефона

<a id="tools"></a>

## Cтек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/" target="_blank" title="Перейти на официальный сайт IntelliJ IDEA"><img width="6%" title="IntelliJ IDEA" src="images/icons/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/" target="_blank" title="Перейти на официальный сайт Java"><img width="6%" title="Java" src="images/icons/Java.svg"></a>
<a href="https://selenide.org/" target="_blank" title="Перейти на официальный сайт Selenide"><img width="6%" title="Selenide" src="images/icons/Selenide.svg"></a>
<a href="https://rest-assured.io/" target="_blank" title="Перейти на официальный сайт REST Assured"><img height="52" title="REST Assured" src="images/icons/Rest_Assured.svg"></a>
<a href="https://aerokube.com/selenoid/" target="_blank" title="Перейти на официальный сайт Selenoid"><img width="6%" title="Selenoid" src="images/icons/Selenoid.svg"></a>
<a href="https://qameta.io/allure-report/" target="_blank" title="Перейти на официальный сайт Allure Report"><img width="6%" title="Allure Report" src="images/icons/Allure_Report.svg"></a>
<a href="https://qameta.io/" target="_blank" title="Перейти на официальный сайт Allure TestOps"><img width="6%" title="Allure TestOps" src="images/icons/Allure_TestOps.svg"></a>
<a href="https://gradle.org/" target="_blank" title="Перейти на официальный сайт Gradle"><img width="6%" title="Gradle" src="images/icons/Gradle.svg"></a>
<a href="https://junit.org/junit5/" target="_blank" title="Перейти на официальный сайт JUnit5"><img width="6%" title="JUnit5" src="images/icons/JUnit5.svg"></a>
<a href="https://github.com/" target="_blank" title="Перейти на официальный сайт GitHub"><img width="6%" title="GitHub" src="images/icons/GitHub.svg"></a>
<a href="https://www.jenkins.io/" target="_blank" title="Перейти на официальный сайт Jenkins"><img width="6%" title="Jenkins" src="images/icons/Jenkins.svg"></a>
<a href="https://telegram.org/" target="_blank" title="Перейти на официальный сайт Telegram"><img width="6%" title="Telegram" src="images/icons/Telegram.svg"></a>
</p>

<a id="console"></a>

## Запуск автотестов

## __Локальный запуск__

> ./gradlew clean test "-DbaseUrl=https://mirmagnitov.ru" "-Dbrowser=chrome" "-DbrowserSize=1920x1080" "-DisHeadless=false"

## __Терминал__ 
> ./gradlew clean test "-DbaseUrl=https://mirmagnitov.ru" "-DremoteUrl=https://{user}:{password}@selenoid.autotests.cloud/wd/hub" "-Dbrowser=chrome" "-DbrowserSize=1920x1080" "-DisHeadless=false" "-DbrowserVersion=128.0"

<a id="jenkins"></a>

## [__Jenkins__](https://jenkins.autotests.cloud/view/java_students/job/C40-Rockerty-Mir-Magnotov/) с параметрами

Сборка автотестов запускается в Jenkins с возможностью выбора параметров окружения перед стартом job.

<p align="center">  
<img title="Jenkins Build Parameters" src="images/screens/Jenkins_build_parameters.png" width="850">  
</p>

Перед запуском сборки в Jenkins необходимо указать параметры:

| Параметр | Описание |
|----------|----------|
| `BaseURL` | Адрес тестируемого сайта |
| `SelenoidRemoteURL` | Адрес удаленной среды, в которой будет запущен браузер |
| `Browser` | Браузер, в котором будут выполняться UI автотесты |
| `BrowserVersion` | Версия браузера для запуска автотестов |
| `BrowserSize` | Размер окна браузера |
| `IsHeadless` | Режим запуска браузера без графического интерфейса |

<a id="allure"></a>

<a id="allure"></a>

## Пример автоматического отчета Allure

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/Allure_screen.png" width="850">  
</p>  

<a id="testops"></a>

## Интеграция с Allure TestOps

В проекте используется Allure TestOps для централизованного хранения результатов автотестов, анализа запусков и управления тестовой документацией.

После выполнения сборки в Jenkins результаты тестов передаются в Allure TestOps, где можно посмотреть:

- историю запусков;
- статус прохождения UI и API автотестов;
- детализацию по каждому тесту;
- шаги выполнения;
- вложения: скриншоты, page source, browser console logs и видео;
- связь автотестов с тест-кейсами.

**Запуск автотестов в Allure TestOps**

<p align="center">  
<img title="Allure TestOps Launch" src="images/screens/Allure_TestOps_launch.png" width="850">  
</p>

**Автоматизированные тест-кейсы**

<p align="center">  
<img title="Allure TestOps Automated Test Cases" src="images/screens/Allure_TestOps_automated_cases.png" width="850">  
</p>

<a id="telegram"></a>

## Уведомления в Telegram

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/TG_report_csreen.png" width="850">  
</p> 

<a id="video"></a>

## Видео выполнения теста
<p align="center">
<img title="Selenoid Video" src="images/videos/4c407e132599fa4dd55a5d64d4811531.gif" width="550" height="350"  alt="video">   
</p>