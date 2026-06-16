package pages;

import static com.codeborne.selenide.Selenide.$x;

public class MirMagnitovCatalogPage {
    private static final String catalogButton = "//*[@class='btn header__catalog-btn']";
    private static final String catalogItemByNameXPathTemplate = "//*[@class='header__catalog header-catalog']//a[.//span[text()='%s']]";

    public void catalogButtonClick() {
        $x(catalogButton).scrollTo().click();
    }

    public void catalogItemHover(String catalogItemName) {
        $x(String.format(catalogItemByNameXPathTemplate, catalogItemName)).hover();
    }

    public void catalogItemClick(String catalogItemName) {
        $x(String.format(catalogItemByNameXPathTemplate, catalogItemName)).scrollTo().click();
    }
}
