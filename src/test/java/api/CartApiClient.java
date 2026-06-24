package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static specs.DefaultSpec.defaultRequestSpec;
import static specs.DefaultSpec.defaultResponseSpec;

public class CartApiClient {

    public static Response addToCart(String sessionId, String uid, String location, String sessid,
                                     int productId, int quantity) {
        String requestBody = String.format(
                "{\"state\":false,\"product\":[%d],\"quantity\":%d}",
                productId, quantity
        );

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
                .when()
                .post("/cart/add/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .spec(defaultResponseSpec)
                .extract()
                .response();
    }

    public static Response addIncorrectItemToCart(String sessionId, String uid, String location, String sessid,
                                     int productId, int quantity) {
        String requestBody = String.format(
                "{\"state\":false,\"product\":[%d],\"quantity\":%d}",
                productId, quantity
        );

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
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

    public static Response removeOneItemFromCart(String sessionId, String uid, String location, String sessid, int cartId) {
        String requestBody = String.format(
                "{\"state\":true,\"cartId\":[%d]}", cartId
        );

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
                .when()
                .post("/cart/remove/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.inCart", hasSize(0))
                .spec(defaultResponseSpec)
                .extract().response();
    }

    public static Response clearCart(String sessionId, String uid, String location, String sessid) {
        String requestBody =
                "{\"state\":true"
        ;

        return given()
                .spec(defaultRequestSpec)
                .cookie("PHP_SESSID", sessionId)
                .cookie("BITRIX_SM_SALE_UID", uid)
                .cookie("BITRIX_SM_LOCATION_CITY", location)
                .queryParam("sessid", sessid)
                .body(requestBody)
                .when()
                .post("/cart/clear/")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("state.inCart", hasSize(0))
                .spec(defaultResponseSpec)
                .extract().response();
    }
}
