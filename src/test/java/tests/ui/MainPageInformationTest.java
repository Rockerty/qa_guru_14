package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MirMagnitovMainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static testdata.TestData.phones;

public class MainPageInformationTest extends MirMagnitovTestBase {
    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

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
    @DisplayName("Главная страница: иконки социальных сетей")
    public void socialNetworkIconsTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Проверить отображение иконок социальных сетей", () -> {
            mirMagnitovMainPage.socialNetworkIconsAssert("Max");
            mirMagnitovMainPage.socialNetworkIconsAssert("WhatsApp");
        });
    }
}
