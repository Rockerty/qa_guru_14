package helpers;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlAssert {

    public static void urlAssert(String url){
        assertEquals(url, url());
    }
}
