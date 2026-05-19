# Rest Assured Otomatik Regresyon Testi Projesi


Bu proje, Yazılım Test Mühendisliği proje ödevi için Java, Maven, JUnit 5 ve Rest Assured kullanılarak hazırlanmış servis otomatik regresyon testi örneğidir.

Test edilen örnek servis: `https://jsonplaceholder.typicode.com`

## Kapsam

- `GET /posts/1` çağrısı ile status code, response body ve response time kontrolleri yapılır.
- `POST /posts` çağrısı ile JSON request body gönderilir; status code, response body ve response time kontrolleri yapılır.
- Testler JUnit 5 ile otomatik çalıştırılır.

## Kullanılan Teknolojiler

- Java 17
- Maven
- JUnit 5
- Rest Assured
- Hamcrest matcher'ları

## Sunum Dosyası

Proje kapsamında hazırlanan sunum dosyası repository içinde `sunum` klasörü altında yer almaktadır.

## Proje Yapısı

```text
.
├── pom.xml
├── README.md
├── sunum
│   └── rest_assured_api_regresyon_sunumu.pdf
└── src
    └── test
        └── java
            └── com
                └── example
                    └── api
                        ├── config
                        │   └── ApiConfig.java
                        ├── model
                        │   └── PostRequest.java
                        └── test
                            ├── BaseApiTest.java
                            └── JsonPlaceholderRegressionTest.java
```

## Testleri Çalıştırma

Bilgisayarda Java 17 ve Maven kurulu olmalıdır.

```bash
mvn test
```

## Test Senaryoları

### GET Senaryosu

Amaç: Sistemde var olan bir post kaydının beklendiği gibi döndüğünü doğrulamak.

Kontroller:

- HTTP status code `200`
- Response time `2000 ms` altında
- `id = 1`
- `userId = 1`
- `title` alanı boş değil
- `body` alanı anlamlı uzunlukta

### POST Senaryosu

Amaç: JSON request body ile yeni post oluşturma isteğinin beklenen cevabı döndürdüğünü doğrulamak.

Kontroller:

- HTTP status code `201`
- Response time `2000 ms` altında
- Response içinde `id` alanı var
- Response içindeki `title`, `body` ve `userId` değerleri gönderilen request body ile aynı


## Hazırlayan

**Eren Özer**  
Bursa Teknik Üniversitesi  
Yazılım Test Mühendisliği Proje Ödevi  
Öğrenci No: 22360859030
