package tests.api;

import api.CartApiClient;
import api.SessionApiClient;

import models.cart.AddToCartRequestModel;
import models.cart.SuccessfulAddToCartResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
            AddToCartRequestModel addToCartRequestModel = new AddToCartRequestModel();
            addToCartRequestModel.setState(false);
            addToCartRequestModel.setProduct(List.of(productId));
            addToCartRequestModel.setQuantity(quantity);

            SuccessfulAddToCartResponseModel successfulAddToCartResponseModel =
                    CartApiClient.addToCart(sessionId, uid, location, sessid, addToCartRequestModel);

            assertEquals(quantity, successfulAddToCartResponseModel.getState().getInCart().get(0).getQuantity());
            assertEquals(productId, successfulAddToCartResponseModel.getState().getInCart().get(0).getProductId());
            assertEquals(quantity, successfulAddToCartResponseModel.getState().getTotal().getCount());
            assertEquals(quantity, successfulAddToCartResponseModel.getState().getTotalHeader().getCount());
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
            AddToCartRequestModel addToCartRequestModel = new AddToCartRequestModel();
            addToCartRequestModel.setState(false);
            addToCartRequestModel.setProduct(List.of(incorrectProductId));
            addToCartRequestModel.setQuantity(quantity);

            CartApiClient.addIncorrectItemToCart(sessionId, uid, location, sessid, addToCartRequestModel);
        });
    }
}