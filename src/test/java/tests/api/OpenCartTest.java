package tests.api;

import api.CartApiClient;
import api.SessionApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartTest extends TestBase {
    private String sessionId;
    private String uid;
    private String location;
    private String sessid;
    private int productId;
    private int quantity;

    @BeforeEach
    public void allTestsSetUp() {
        productId = 187544;
        quantity = 1;
    }

    @Test
    public void successfulOpenCartWithItemTest() {
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление в корзину корректного товара", () -> {
            CartApiClient.addToCart(sessionId, uid, location, sessid, productId, quantity)
                    .then()
                    .statusCode(200)
                    .body("success", is(true))
                    .body("state.inCart[0].productId", equalTo(187544));
        });

        step("Получение корзины и проверка товара", () -> {
            String cartHtml = CartApiClient.getCart(sessionId, uid, location, sessid)
                    .then()
                    .statusCode(200)
                    .extract()
                    .asString();

            String expectedProductId = "\"productId\":" + productId;

            assertTrue(
                    cartHtml.contains(expectedProductId),
                    "В HTML корзины не найдено значение " + expectedProductId
            );
        });
    }
}
