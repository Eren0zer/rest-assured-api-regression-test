package com.example.api.test;

import com.example.api.config.ApiConfig;
import com.example.api.model.PostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

@Tag("regression")
class JsonPlaceholderRegressionTest extends BaseApiTest {

    @Test
    @DisplayName("GET /posts/1 should return expected post details under response time limit")
    void getPostByIdShouldReturnExpectedPost() {
        // given: İstek için gerekli ortak ayarlar hazırlanır.
        given()
                .spec(requestSpec)
        // when: /posts/1 endpoint'ine GET isteği gönderilir.
        .when()
                .get("/posts/{postId}", 1)
        // then: Dönen cevabın status code, süre ve body kontrolleri yapılır.
        .then()
                .log().body()
                .statusCode(200)
                .time(lessThan(ApiConfig.MAX_RESPONSE_TIME_MS))
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", notNullValue())
                .body("body.length()", greaterThan(20));
    }

    @Test
    @DisplayName("POST /posts should create a post with request body values")
    void createPostShouldReturnCreatedPost() {
        // POST isteğinde gönderilecek JSON body değerleri hazırlanır.
        PostRequest requestBody = new PostRequest(
                "Yazilim test muhendisligi",
                "Rest Assured ile otomatik regresyon testi ornegi",
                7
        );

        // given: Ortak ayarlar ve request body isteğe eklenir.
        given()
                .spec(requestSpec)
                .body(requestBody)
        // when: /posts endpoint'ine POST isteği gönderilir.
        .when()
                .post("/posts")
        // then: Oluşturma cevabı, süre ve dönen body değerleri doğrulanır.
        .then()
                .log().body()
                .statusCode(201)
                .time(lessThan(ApiConfig.MAX_RESPONSE_TIME_MS))
                .body("id", notNullValue())
                .body("title", equalTo(requestBody.getTitle()))
                .body("body", equalTo(requestBody.getBody()))
                .body("userId", equalTo(requestBody.getUserId()));
    }
}
