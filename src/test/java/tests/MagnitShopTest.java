package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MirMagnitovMainPage;

import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

import static testData.TestData.*;

public class MagnitShopTest {
    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

    @BeforeEach
    void everyTestsSetUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void allTestsSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = System.getProperty("baseUrl");;
        Configuration.remote = System.getProperty("selenoidRemoteURL");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("isHeadless"));
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.pageLoadStrategy = "eager";

        Configuration.timeout = 10000;
        //Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://mirmagnitov.ru/";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @DisplayName("Главная страница: телефонный номер")
    public void phoneNumberOnMainPageTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Проверить телефонный номер на главной странице", () -> {
            mirMagnitovMainPage.phoneNumberOnMainPageAssert(phones);
        });

    }

    @Test
    @DisplayName("Главная страница: текущий город")
    public void changeCurrentCityTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Изменить текущий город", () -> {
            mirMagnitovMainPage.openPage();
            mirMagnitovMainPage.cityChange("Москва");
        });

        step("Проверить текст текущего склада", () -> {
            mirMagnitovMainPage.currentCityAssert("8-й пр. Марьиной Рощи, 30, стр. 2");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Доставка и оплата'")
    public void urlDeliveryTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'Доставка и оплата'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("Доставка и оплата");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/delivery/");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Контакты'")
    public void urlContactTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'Контакты'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("Контакты");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/contacts/");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Помощь и советы'")
    public void urlFAQTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'Помощь и советы'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("Помощь и советы");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/faq/");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Купить оптом'")
    public void urlWholesalersTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'Купить оптом'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("Купить оптом");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/wholesalers/");
        });
    }
}
