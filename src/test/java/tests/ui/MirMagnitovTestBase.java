package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MirMagnitovTestBase {

    @BeforeEach
    void everyTestsSetUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void allTestsSetUp() {
//        Configuration.browser = webDriverConfig.getBrowser();
//        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
//        Configuration.browserSize = webDriverConfig.getBrowserSize();
//        Configuration.baseUrl = webDriverConfig.getBaseUrl();
//
//        if (webDriverConfig.getRemoteUrl() != null) {
//            Configuration.remote = webDriverConfig.getRemoteUrl().toString();
//
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                    "enableVNC", true,
//                    "enableVideo", true
//            ));
//            Configuration.browserCapabilities = capabilities;
//        }

        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://mirmagnitov.ru";
        Configuration.browserSize = "1920x1080";
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
}
