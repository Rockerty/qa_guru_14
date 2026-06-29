package tests.api;

import api.CartApiClient;
import api.SessionApiClient;
import models.cart.AddToCartRequestModel;
import models.cart.ClearCartRequestModel;
import models.cart.RemoveOneItemFromCartRequestModel;
import models.cart.SuccessfulAddToCartResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
            AddToCartRequestModel addToCartRequestModel = new AddToCartRequestModel();
            addToCartRequestModel.setState(false);
            addToCartRequestModel.setProduct(List.of(productId));
            addToCartRequestModel.setQuantity(quantity);

            SuccessfulAddToCartResponseModel successfulAddToCartResponseModel =
                    CartApiClient.addToCart(sessionId, uid, location, sessid, addToCartRequestModel);

            cartId = successfulAddToCartResponseModel.getState().getInCart().get(0).getCartId();
        });

        step("Удаление товара из корзины", () -> {
            RemoveOneItemFromCartRequestModel removeOneItemFromCartRequestModel = new RemoveOneItemFromCartRequestModel();
            removeOneItemFromCartRequestModel.setState(true);
            removeOneItemFromCartRequestModel.setCartId(List.of(cartId));

            CartApiClient.removeOneItemFromCart(sessionId, uid, location, sessid, removeOneItemFromCartRequestModel);
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
            AddToCartRequestModel addToCartRequestModel = new AddToCartRequestModel();
            addToCartRequestModel.setState(false);
            addToCartRequestModel.setProduct(List.of(productId));
            addToCartRequestModel.setQuantity(quantity);

            SuccessfulAddToCartResponseModel successfulAddToCartResponseModel =
                    CartApiClient.addToCart(sessionId, uid, location, sessid, addToCartRequestModel);

            assertEquals(productId, successfulAddToCartResponseModel.getState().getInCart().get(0).getProductId());
        });

        step("Добавление второго товара в корзину", () -> {
            AddToCartRequestModel addToCartRequestModel = new AddToCartRequestModel();
            addToCartRequestModel.setState(false);
            addToCartRequestModel.setProduct(List.of(secondProductId));
            addToCartRequestModel.setQuantity(quantity);

            SuccessfulAddToCartResponseModel successfulAddToCartResponseModel =
                    CartApiClient.addToCart(sessionId, uid, location, sessid, addToCartRequestModel);

            assertEquals(secondProductId, successfulAddToCartResponseModel.getState().getInCart().get(1).getProductId());
        });

        step("Очистка корзины", () -> {
            ClearCartRequestModel clearCartRequestModel = new ClearCartRequestModel();
            clearCartRequestModel.setState(true);

            CartApiClient.clearCart(sessionId, uid, location, sessid, clearCartRequestModel);
        });
    }
}
