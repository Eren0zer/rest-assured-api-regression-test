package com.example.api.model;

public class PostRequest {
    // POST isteğinde JSON body olarak gönderilecek alanlar.
    private String title;
    private String body;
    private int userId;

    // Jackson kütüphanesinin Java nesnesini JSON'a çevirebilmesi için boş constructor gerekir.
    public PostRequest() {
    }

    public PostRequest(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }
}
