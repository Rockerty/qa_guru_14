package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MirMagnitovCatalogPage;
import pages.MirMagnitovMainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.UrlAssert.urlAssert;

public class CatalogNavigationTest extends MirMagnitovTestBase {
    private final MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();
    private final MirMagnitovCatalogPage mirMagnitovCatalogPage = new MirMagnitovCatalogPage();

    @Test
    @DisplayName("Навигация по каталогу: второй уровень вложенности")
    public void catalogNavigationForPostoyannyeMagnityTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Открыть каталог", () -> {
            mirMagnitovCatalogPage.catalogButtonClick();
        });

        step("Навести курсор на раздел первого уровня", () -> {
            mirMagnitovCatalogPage.catalogItemHover("Постоянные магниты");
        });

        step("Перейти в раздел второго уровня", () -> {
            mirMagnitovCatalogPage.catalogItemClick("Неодимовые магниты");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/catalog/postoyannye-magnity/neodimovye-magnity/");
        });
    }

    @Test
    @DisplayName("Навигация по каталогу: третий уровень вложенности")
    public void catalogNavigationForSKleevymSloemTest() {
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Открыть каталог", () -> {
            mirMagnitovCatalogPage.catalogButtonClick();
        });

        step("Навести курсор на раздел первого уровня", () -> {
            mirMagnitovCatalogPage.catalogItemHover("Гибкие магниты");
        });

        step("Навести курсор на раздел второго уровня", () -> {
            mirMagnitovCatalogPage.catalogItemHover("Магнитная лента");
        });

        step("Перейти в раздел третьего уровня", () -> {
            mirMagnitovCatalogPage.catalogItemClick("Лента с клеевым слоем");
        });

        step("Проверить текущий URL", () -> {
            urlAssert("https://mirmagnitov.ru/catalog/gibkie-magnity/magnitnaya-lenta/s-kleevym-sloem/");
        });
    }
}
