package adapters;

import com.google.gson.Gson;
import constants.IConstants;
import utils.PropertyReader;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IConstants {
    Gson gson = new Gson();
    String auth = PropertyReader.getProperty("EMAIL") + ":" + API_KEY;
    String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

    public String get(String url) {
        return
                given()
                        .log().all()
                        .header(AUTHORIZATION, "Basic " + encodedAuth)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .when()
                        .get(BASE_URL_API + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }

    public String post(String url, String body) {
        return
                given()
                        .log().all()
                        .header(AUTHORIZATION, "Basic " + encodedAuth)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .body(body)
                        .when()
                        .post(BASE_URL_API + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }

    public String postWithoutBody(String url) {
        return
                given()
                        .log().all()
                        .header(AUTHORIZATION, "Basic " + encodedAuth)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .when()
                        .post(BASE_URL_API + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }
}