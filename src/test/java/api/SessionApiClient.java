package api;

import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class SessionApiClient {

    public static String[] getSessionData() {
        Response response = given()
                .get("/")
                .then()
                .statusCode(200)
                .extract().response();

        String sessionId = response.getCookie("PHP_SESSID");
        String uid = response.getCookie("BITRIX_SM_SALE_UID");
        String location = response.getCookie("BITRIX_SM_LOCATION_CITY");

        String html = response.asString();
        Document doc = Jsoup.parse(html);
        String sessid = null;

        for (org.jsoup.nodes.Element script : doc.select("script[data-skip-moving=true]")) {
            String data = script.data();

            if (data.contains("window.APP")) {
                Matcher matcher = Pattern.compile("\\\"sessid\\\":\\\"([^\\\"]+)\\\"").matcher(data);

                if (matcher.find()) {
                    sessid = matcher.group(1);
                    break;
                }
            }
        }

        if (sessid == null) {
            throw new RuntimeException("sessid не найден");
        }

        return new String[]{sessionId, uid, location, sessid};
    }
}
