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
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://mirmagnitov.ru/";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserVersion = "128.0";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void catalogNavigationForPostoyannyeMagnityTest() {

        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Перейти в каталоге к разделу второго уровня", () -> {
            mirMagnitovMainPage.catalogSecondLevelNavigation("Постоянные магниты", "Неодимовые магниты");
        });

        step("Проверить текущий URL", () -> {
            mirMagnitovMainPage.urlAssert("https://mirmagnitov.ru/catalog/postoyannye-magnity/neodimovye-magnity/");
        });
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
