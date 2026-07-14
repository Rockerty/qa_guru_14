package tests.api;

import api.FavoriteApiClient;
import api.SessionApiClient;
import models.favorite.AddToFavoriteRequestModel;
import models.favorite.ClearFavoriteRequestModel;
import models.favorite.RemoveFromFavoriteRequestModel;
import models.favorite.SuccessfulAddToFavoriteResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveFromFavoriteTest extends TestBase {
    private final int productId = 187544;

    @Test
    public void removeFromFavoriteTest(){

        step("Добавление товара в избранное", () -> {
            AddToFavoriteRequestModel addToFavoriteRequestModel = new AddToFavoriteRequestModel();
            addToFavoriteRequestModel.setProductId(productId);

            SuccessfulAddToFavoriteResponseModel successfulAddToFavoriteResponseModel =
                    FavoriteApiClient.addToFavorite(sessionId, uid, location, sessid, addToFavoriteRequestModel);

            assertEquals(productId, successfulAddToFavoriteResponseModel.getState().getProductIds().get(0));
        });

        step("Удаление товара из избранного", () -> {
            RemoveFromFavoriteRequestModel removeFromFavoriteRequestModel = new RemoveFromFavoriteRequestModel();
            removeFromFavoriteRequestModel.setProductId(productId);

            FavoriteApiClient.removeFromFavorite(sessionId, uid, location, sessid, removeFromFavoriteRequestModel);
        });
    }

    @Test
    public void clearFavoriteListTest(){
        step("Добавление товара в избранное", () -> {
            AddToFavoriteRequestModel addToFavoriteRequestModel = new AddToFavoriteRequestModel();
            addToFavoriteRequestModel.setProductId(productId);

            SuccessfulAddToFavoriteResponseModel successfulAddToFavoriteResponseModel =
                    FavoriteApiClient.addToFavorite(sessionId, uid, location, sessid, addToFavoriteRequestModel);

            assertEquals(productId, successfulAddToFavoriteResponseModel.getState().getProductIds().get(0));
        });

        step("Очистка списка избранного", () -> {
            ClearFavoriteRequestModel clearFavoriteRequestModel = new ClearFavoriteRequestModel();

            FavoriteApiClient.clearFavorite(sessionId, uid, location, sessid, clearFavoriteRequestModel);
        });
    }
}
