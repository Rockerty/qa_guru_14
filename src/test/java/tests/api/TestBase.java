package tests.api;

import api.SessionApiClient;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.qameta.allure.Allure.step;

public class TestBase {
    protected static String sessionId;
    protected static String uid;
    protected static String location;
    protected static String sessid;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://mirmagnitov.ru";

        step("Получение сессии и токена", () -> {
            String[] data = SessionApiClient.getSessionData();
            sessionId = data[0];
            uid = data[1];
            location = data[2];
            sessid = data[3];
        });
    }
}