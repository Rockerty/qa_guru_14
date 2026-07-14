package tests.api;

import api.CartApiClient;
import models.cart.AddToCartRequestModel;
import models.cart.ClearCartRequestModel;
import models.cart.RemoveOneItemFromCartRequestModel;
import models.cart.SuccessfulAddToCartResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class DeleteFromCartTest extends TestBase {
    private final int productId = 187544;
    private final int secondProductId = 188031;
    private final int quantity = 1;
    private int cartId;

    @Test
    public void deleteOneItemFromCartTest() {
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
