package tests.api;

import api.CartApiClient;
import models.cart.AddToCartRequestModel;
import models.cart.SuccessfulAddToCartResponseModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartTest extends TestBase {
    private final int productId = 187544;
    private final int quantity = 1;;

    @Test
    public void successfulOpenCartWithItemTest() {
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
