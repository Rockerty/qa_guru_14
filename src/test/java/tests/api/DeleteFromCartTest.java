package tests.api;

import api.CartApiClient;
import api.SessionApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class DeleteFromCartTest extends TestBase {
    private String sessionId;
    private String uid;
    private String location;
    private String sessid;
    private int productId;
    private int secondProductId;
    private int quantity;
    private int cartId;

    @BeforeEach
    public void allTestsSetUp() {
        productId = 187544;
        quantity = 1;
        secondProductId = 188031;
    }

    @Test
    public void deleteOneItemFromCartTest() {
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление в корзину товара", () -> {
            Response response = CartApiClient.addToCart(sessionId, uid, location, sessid, productId, quantity);

            cartId = response.jsonPath().getInt("state.inCart[0].cartId");
        });

        step("Удаление товара из корзины", () -> {
            CartApiClient.removeOneItemFromCart(sessionId, uid, location, sessid, cartId);
        });
    }

    @Test
    public void removeAllItemsFromCartTest() {
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление в корзину товара", () -> {
            Response response = CartApiClient.addToCart(sessionId, uid, location, sessid, productId, quantity);

            response.then().body("state.inCart[0].productId", equalTo(productId));

            cartId = response.jsonPath().getInt("state.inCart[0].cartId");
        });

        step("Добавление второго товара в корзину", () -> {
            Response response = CartApiClient.addToCart(sessionId, uid, location, sessid, secondProductId, quantity);

            response.then().body("state.inCart[1].productId", equalTo(secondProductId));

            cartId = response.jsonPath().getInt("state.inCart[1].cartId");
        });

        step("Удаление товара из корзины", () -> {
            CartApiClient.clearCart(sessionId, uid, location, sessid);
        });
    }
}
