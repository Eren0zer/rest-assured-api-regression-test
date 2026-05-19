package com.example.api.test;

import com.example.api.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseApiTest {
    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setUpApiClient() {
        // Bütün testler için ortak base URL tanımlanır.
        RestAssured.baseURI = ApiConfig.BASE_URI;

        // Her istekte JSON gönderip JSON cevap beklediğimizi belirten ortak request ayarı.
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new ErrorLoggingFilter())
                .build();
    }
}
