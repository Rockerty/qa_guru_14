package api;

import io.restassured.response.Response;
import models.favorite.AddToFavoriteRequestModel;
import models.favorite.ClearFavoriteRequestModel;
import models.favorite.RemoveFromFavoriteRequestModel;
import models.favorite.SuccessfulAddToFavoriteResponseModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static specs.DefaultSpec.defaultRequestSpec;
import static specs.DefaultSpec.defaultResponseSpec;

public class FavoriteApiClient {

    public static SuccessfulAddToFavoriteResponseModel addToFavorite(String sessionId, String uid, String location, String sessid,
                                                                     AddToFavoriteRequestModel addToFavoriteRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(addToFavoriteRequestModel)
                .when()
                .post("/catalog/favorite/add/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .spec(defaultResponseSpec)
                .extract()
                .as(SuccessfulAddToFavoriteResponseModel.class);
    }

    public static Response removeFromFavorite(String sessionId, String uid, String location, String sessid,
                                              RemoveFromFavoriteRequestModel removeFromFavoriteRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(removeFromFavoriteRequestModel)
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

    public static Response clearFavorite(String sessionId, String uid, String location, String sessid,
                                         ClearFavoriteRequestModel clearFavoriteRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(clearFavoriteRequestModel)
                .when()
                .post("/catalog/favorite/clear/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.productIds", hasSize(0))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }
}
