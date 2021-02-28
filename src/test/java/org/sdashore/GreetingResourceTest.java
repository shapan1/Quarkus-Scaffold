package org.sdashore;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/hello/get").then().statusCode(200)
                .body(is("URI: http://localhost:8081/hello/get - Order null - Authorization: null"));
    }

    // @Test
    // public void testPostHelloEndpoint() {
    // given().when().post("/hello/post").then().statusCode(200);
    // }

    @Test
    public void testUpdateHelloEndpoint() {
        given().when().put("/hello/put").then().statusCode(200).body(is("PUT method - update"));
    }

}