package tests;

import org.junit.jupiter.api.*;
import pages.MirMagnitovMainPage;
import testbases.MirMagnitovTestBase;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.UrlAssert.urlAssert;
import static testdata.TestData.*;

public class MagnitShopTest extends MirMagnitovTestBase {
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

        step("Проверить отображении иконок социальных сетей", () -> {
            mirMagnitovMainPage.socialNetworkIconsAssert("Max");
            mirMagnitovMainPage.socialNetworkIconsAssert("WhatsApp");
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
            urlAssert("https://mirmagnitov.ru/delivery/");
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
            urlAssert("https://mirmagnitov.ru/contacts/");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Помощь и советы'")
    public void urlFAQTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'FAQ'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("FAQ");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/faq/");
        });
    }

    @Test
    @DisplayName("Главная страница: раздел 'Акции и скидки'")
    public void urlWholesalersTabTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на раздел 'Акции и скидки'", () -> {
            mirMagnitovMainPage.mainPageTabEnter("Акции и скидки");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/promotions/");
        });
    }
}
