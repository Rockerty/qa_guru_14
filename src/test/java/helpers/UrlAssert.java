package helpers;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrlAssert {

    public static void urlAssert(String expectedUrl) {
        assertEquals(expectedUrl, url());
    }

    public static void urlContainsAssert(String expectedUrlPart) {
        String currentUrl = url();

        assertNotNull(currentUrl, "Текущий URL равен null");

        assertTrue(
                currentUrl.contains(expectedUrlPart),
                "Текущий URL не содержит ожидаемое значение. Ожидали часть URL: "
                        + expectedUrlPart
                        + ", текущий URL: "
                        + currentUrl
        );
    }
}