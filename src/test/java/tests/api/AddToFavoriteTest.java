package tests.api;

import api.FavoriteApiClient;
import api.SessionApiClient;
import models.favorite.AddToFavoriteRequestModel;
import models.favorite.SuccessfulAddToFavoriteResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToFavoriteTest extends TestBase {
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
    public void addItemToFavoriteTest(){
        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });

        step("Добавление товара в изранное", () -> {
            AddToFavoriteRequestModel addToFavoriteRequestModel = new AddToFavoriteRequestModel();
            addToFavoriteRequestModel.setProductId(productId);

            SuccessfulAddToFavoriteResponseModel successfulAddToFavoriteResponseModel =
                    FavoriteApiClient.addToFavorite(sessionId, uid, location, sessid, addToFavoriteRequestModel);

            assertEquals(productId, successfulAddToFavoriteResponseModel.getState().getProductIds().get(0));
        });
    }
}
