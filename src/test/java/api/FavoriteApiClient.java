package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static specs.DefaultSpec.defaultRequestSpec;
import static specs.DefaultSpec.defaultResponseSpec;

public class FavoriteApiClient {

    public static Response addToFavorite(String sessionId, String uid, String location, String sessid, int productId) {
        String requestBody = String.format("{\"productId\":%d}", productId);

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
                .when()
                .post("/catalog/favorite/add/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }

    public static Response removeFromFavorite(String sessionId, String uid, String location, String sessid, int productId) {
        String requestBody = String.format("{\"productId\":%d}", productId);

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
                .when()
                .post("/catalog/favorite/remove/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.productIds", hasSize(0))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }
}
