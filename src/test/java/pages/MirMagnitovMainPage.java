package pages;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MirMagnitovMainPage {
    private static final String phoneNumberOnMainPage = "//*[@class='header__phone-top']";
    private static final String currentCity = "//div[@class='vue-header-city']//button";
    private static final String cityXPathTemplate = "//a[contains(text(), '%s')]";
    private static final String currentStorageBlockText = "(//div[@class='header-block__text'])[1]";
    private static final String mainPageTabNameXPathTemplate = "//div[@class='footer-nav__items']//a[text()='%s']";
    private static final String socialNetworkIconXPathTemplate = "//*[@class='header__socials']//a[@title='%s']";
    private static final String marketplaceLinkXPathTemplate = "//div[contains(@class, 'trust-platforms__grid')]//a[contains(@href, '%s')]";


    public void openPage() {
        open("");
    }

    public void cityChange(String cityName) {
        $x(currentCity).scrollTo().click();
        $x(String.format(cityXPathTemplate, cityName)).scrollTo().click();
    }

    public void currentCityAssert(String storageName) {
        $x(currentStorageBlockText).shouldHave(text(storageName));
    }

    public void phoneNumberOnMainPageAssert(List<String> phoneNumbers) {
        String blockText = $x(phoneNumberOnMainPage).getText();
        boolean found = phoneNumbers.stream().anyMatch(blockText::contains);
        assertTrue(found, "Ни один из телефонов " + phoneNumbers + " не найден в тексте: " + blockText);
    }

    public void mainPageTabEnter(String tabName) {
        $x(String.format(mainPageTabNameXPathTemplate, tabName)).scrollTo().click();
    }

    public void socialNetworkIconsAssert(String socialNetworkName) {
        $x(String.format(socialNetworkIconXPathTemplate, socialNetworkName)).scrollTo().shouldBe(visible);
    }

    public void marketplaceMainPageButtonClick(String marketplaceName) {
        $x(String.format(marketplaceLinkXPathTemplate, marketplaceName)).scrollTo().click();
    }
}