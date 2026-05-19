package com.example.api.config;

public final class ApiConfig {
    // Testlerde kullanılacak ortak API adresi.
    public static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    // Servis cevabının en fazla kaç milisaniyede dönmesi gerektiğini belirtir.
    public static final long MAX_RESPONSE_TIME_MS = 7000L;

    private ApiConfig() {
    }
}
