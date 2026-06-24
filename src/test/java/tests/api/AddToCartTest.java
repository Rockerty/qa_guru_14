package tests.api;

import api.CartApiClient;
import api.SessionApiClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AddToCartTest extends TestBase {
    private String sessionId;
    private String uid;
    private String location;
    private String sessid;
    private int productId;
    private int incorrectProductId;
    private int quantity;

    @BeforeEach
    public void allTestsSetUp() {
        productId = 187544;
        incorrectProductId = 777;
        quantity = 1;
    }

    @Test
    public void successAddToCartTest() {
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление в корзину корректного товара", () -> {
            CartApiClient.addToCart(sessionId, uid, location, sessid, productId, quantity);
        });
    }

    @Test
    public void incorrectItemToCartTest(){
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление в корзину некорректного товара", () -> {
            CartApiClient.addIncorrectItemToCart(sessionId, uid, location, sessid, incorrectProductId, quantity);
        });
    }
}