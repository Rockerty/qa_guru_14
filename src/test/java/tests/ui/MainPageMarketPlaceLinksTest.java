package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MirMagnitovMainPage;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.UrlAssert.urlContainsAssert;

public class MainPageMarketPlaceLinksTest extends MirMagnitovTestBase {
    MirMagnitovMainPage mirMagnitovMainPage = new MirMagnitovMainPage();

    @Test
    @DisplayName("Главная страница: переход на сайт Озон'")
    public void ozonLinkFromMainPageTest(){
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на кнопку перехода в магазин Озон", () -> {
            mirMagnitovMainPage.marketplaceMainPageButtonClick("ozon");
        });

        step("Переключиться на новую вкладку", () -> {
            switchTo().window(1);
        });

        step("Проверить, что текущий URL содержит маркетплейс", () -> {
            urlContainsAssert("ozon.ru");
        });
    }

    @Test
    @DisplayName("Главная страница: переход на сайт Wildberries'")
    public void wildberriesLinkFromMainPageTest(){
        step("Открыть главную страницу", () -> {
            mirMagnitovMainPage.openPage();
        });

        step("Нажать на кнопку перехода в магазин Wildberries", () -> {
            mirMagnitovMainPage.marketplaceMainPageButtonClick("wildberries");
        });

        step("Переключиться на новую вкладку", () -> {
            switchTo().window(1);
        });

        step("Проверить, что текущий URL содержит маркетплейс", () -> {
            urlContainsAssert("wildberries.ru");
        });
    }
}
