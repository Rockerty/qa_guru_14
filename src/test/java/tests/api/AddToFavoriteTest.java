package tests.api;

import api.CartApiClient;
import api.FavoriteApiClient;
import api.SessionApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.equalTo;

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
            Response response = FavoriteApiClient.addToFavorite(sessionId, uid, location, sessid, productId);

            response.then().body("state.productIds[0]", equalTo(productId));
        });
    }
}
