package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MirMagnitovMainPage;

import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class CatalogNavigationTest {

    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

    @BeforeEach
    void everyTestsSetUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void allTestsSetUp() {
        WebDriverManager.chromedriver().setup();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        //Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = System.getProperty("baseUrl");;
        //Configuration.remote = System.getProperty("selenoidRemoteURL");
        //Configuration.headless = Boolean.parseBoolean(System.getProperty("isHeadless"));
        Configuration.browser = System.getProperty("browser");
        //Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.pageLoadStrategy = "eager";
        //Configuration.timeout = 10000;


        Configuration.timeout = 10000;
        //Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://mirmagnitov.ru/";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void catalogNavigationForPostoyannyeMagnityTest() {
        System.out.println("=== Диагностика ===");
        System.out.println("1. baseUrl = " + System.getProperty("baseUrl"));
        System.out.println("2. browser = " + System.getProperty("browser"));
        System.out.println("3. mirMagnitovMainPage = " + mirMagnitovMainPage);

        step("Открыть главную страницу", () -> {
            System.out.println("4. Вызов openPage()");
            mirMagnitovMainPage.openPage();
            System.out.println("5. openPage() выполнен");
        });

        step("Перейти в каталоге к разделу второго уровня", () -> {
            System.out.println("6. Вызов catalogSecondLevelNavigation()");
            mirMagnitovMainPage.catalogSecondLevelNavigation("Постоянные магниты", "Неодимовые магниты");
            System.out.println("7. catalogSecondLevelNavigation() выполнен");
        });

        step("Проверить текущий URL", () -> {
            System.out.println("8. Вызов urlAssert()");
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/catalog/postoyannye-magnity/neodimovye-magnity/");
            System.out.println("9. urlAssert() выполнен");
        });

        System.out.println("=== Тест завершен ===");
    }

    @Test
    public void catalogNavigationForSKleevymSloemTest() {

        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Перейти в каталоге к разделу второго уровня", () -> {
            mirMagnitovMainPage.catalogThirdLevelNavigation("Гибкие магниты", "Магнитная лента", "Лента с клеевым слоем");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/catalog/gibkie-magnity/magnitnaya-lenta/s-kleevym-sloem/");
        });
    }
}
