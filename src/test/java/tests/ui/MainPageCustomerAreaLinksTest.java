package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MirMagnitovMainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.UrlAssert.urlAssert;

public class MainPageCustomerAreaLinksTest extends MirMagnitovTestBase {
    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

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
    public void urlPromotionsTabTest() {
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
