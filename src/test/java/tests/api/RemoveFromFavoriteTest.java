package tests.api;

import api.FavoriteApiClient;
import api.SessionApiClient;
import models.favorite.AddToFavoriteRequestModel;
import models.favorite.ClearFavoriteRequestModel;
import models.favorite.RemoveFromFavoriteRequestModel;
import models.favorite.SuccessfulAddToFavoriteResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveFromFavoriteTest extends TestBase {
    private String sessionId;
    private String uid;
    private String location;
    private String sessid;
    private int productId;

    @BeforeEach
    public void allTestsSetUp() {
        productId = 187544;
    }

    @Test
    public void removeFromFavoriteTest(){
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

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
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

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
