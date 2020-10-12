package com.github.natezhengbne;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.vertx.http.runtime.security.HttpAuthenticationMechanism;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import org.junit.jupiter.api.Test;
import io.quarkus.test.h2.H2DatabaseTestResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
//@QuarkusTestResource(H2DatabaseTestResource.class)
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
                .log().all()
             .statusCode(200)
             .body(is("123"));
    }

    @Test()
    public void testSecureAccessSuccess() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        given().auth()
                .form("admin", "test",
                        new FormAuthConfig("j_security_check", "j_username", "j_password")
                                .withLoggingEnabled())
                .when().get("/secure-test")
                .then().statusCode(200);
    }

    @Test()
    public void testSecureAccess403() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        given().auth()
                .form("jdoe", "p4ssw0rd",
                        new FormAuthConfig("j_security_check", "j_username", "j_password")
                                .withLoggingEnabled())
                .when().get("/secure-test").then().statusCode(403);
    }

}