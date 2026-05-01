package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MirMagnitovMainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.UrlAssert.urlAssert;

public class CatalogNavigationTest extends MirMagnitovTestBase {

    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

    @Test
    @DisplayName("Навигация по каталогу: второй уровень вложенности")
    public void catalogNavigationForPostoyannyeMagnityTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Открыть каталог", () -> {
            mirMagnitovMainPage.catalogButtonClick();
        });

        step("Навести курсор на раздел первого уровня", () -> {
            mirMagnitovMainPage.catalogItemHover("Постоянные магниты");
        });

        step("Перейти в раздел второго уровня", () -> {
            mirMagnitovMainPage.catalogItemClick("Неодимовые магниты");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/catalog/postoyannye-magnity/neodimovye-magnity/");
        });
    }

    @Test
    @DisplayName("Навигация по каталогу: третий уровень вложенности")
    public void catalogNavigationForSKleevymSloemTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Открыть каталог", () -> {
            mirMagnitovMainPage.catalogButtonClick();
        });

        step("Навести курсор на раздел первого уровня", () -> {
            mirMagnitovMainPage.catalogItemHover("Гибкие магниты");
        });

        step("Навести курсор на раздел второго уровня", () -> {
            mirMagnitovMainPage.catalogItemHover("Магнитная лента");
        });

        step("Перейти в раздел третьего уровня", () -> {
            mirMagnitovMainPage.catalogItemClick("Лента с клеевым слоем");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/catalog/gibkie-magnity/magnitnaya-lenta/s-kleevym-sloem/");
        });
    }
}