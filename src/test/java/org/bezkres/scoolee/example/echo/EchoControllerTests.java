package org.bezkres.scoolee.example.echo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EchoControllerTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testSendEchoOk() {
        given().contentType(ContentType.JSON)
            .body("""
                    {
                      "text": "test message"
                    }
                    """)
            .when()
                .post("/echo")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body("timestamp", notNullValue())
                .body("text", equalTo("test message"));
    }
}
