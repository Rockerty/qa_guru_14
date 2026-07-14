package tests.api;

import api.FavoriteApiClient;
import models.favorite.AddToFavoriteRequestModel;
import models.favorite.SuccessfulAddToFavoriteResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToFavoriteTest extends TestBase {
    private final int productId = 187544;

    @Test
    public void addItemToFavoriteTest(){
        step("Добавление товара в изранное", () -> {
            AddToFavoriteRequestModel addToFavoriteRequestModel = new AddToFavoriteRequestModel();
            addToFavoriteRequestModel.setProductId(productId);

            SuccessfulAddToFavoriteResponseModel successfulAddToFavoriteResponseModel =
                    FavoriteApiClient.addToFavorite(sessionId, uid, location, sessid, addToFavoriteRequestModel);

            assertEquals(productId, successfulAddToFavoriteResponseModel.getState().getProductIds().get(0));
        });
    }
}
