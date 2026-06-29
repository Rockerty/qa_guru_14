package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static specs.DefaultSpec.defaultRequestSpec;
import static specs.DefaultSpec.defaultResponseSpec;

import models.cart.AddToCartRequestModel;
import models.cart.ClearCartRequestModel;
import models.cart.RemoveOneItemFromCartRequestModel;
import models.cart.SuccessfulAddToCartResponseModel;

public class CartApiClient {

    public static SuccessfulAddToCartResponseModel addToCart(String sessionId, String uid, String location, String sessid,
                                                             AddToCartRequestModel addToCartRequestModel) {

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(addToCartRequestModel)
                .when()
                .post("/cart/add/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .spec(defaultResponseSpec)
                .extract()
                .as(SuccessfulAddToCartResponseModel.class);
    }

    public static Response addIncorrectItemToCart(String sessionId, String uid, String location, String sessid,
                                                  AddToCartRequestModel addToCartRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(addToCartRequestModel)
                .when()
                .post("/cart/add/")
                .then()
                .statusCode(422)
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }

    public static Response getCart(String sessionId, String uid, String location, String sessid) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .when()
                .get("/cart/")
                .then()
                .spec(defaultResponseSpec)
                .extract().response();
    }

    public static Response removeOneItemFromCart(String sessionId, String uid, String location, String sessid,
                                                 RemoveOneItemFromCartRequestModel removeOneItemFromCartRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(removeOneItemFromCartRequestModel)
                .when()
                .post("/cart/remove/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.inCart", hasSize(0))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }

    public static Response clearCart(String sessionId, String uid, String location, String sessid,
                                     ClearCartRequestModel clearCartRequestModel) {
        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(clearCartRequestModel)
                .when()
                .post("/cart/clear/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.inCart", hasSize(0))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }
}
