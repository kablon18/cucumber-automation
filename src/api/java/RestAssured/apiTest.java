package RestAssured;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static io.restassured.RestAssured.given;

public class apiTest {

    private static final Logger logger = LoggerFactory.getLogger(apiTest.class);
    private final String BASE_URI = "https://dummyjson.com";
    private final String USERS_BASE_URI = "https://reqres.in/api";
    private final String RESOURCE_PATH = "/products";

    @Test
    public void getListOfUsersOfPage(){
        baseURI = USERS_BASE_URI;

        // Perform get all items in page 1
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users?page=1");

        // Extract and print the response
        int statusCode = response.getStatusCode();
        logger.info("Status Code: {}", statusCode);

        String responseBody = response.getBody().asString();
        logger.info("Response Body: {}", responseBody);
    }

    @Test
    public void getUserByID(){
        baseURI = USERS_BASE_URI;

        // Perform get item by id
        Response response =
                RestAssured.given()
                        .queryParam("id", 1)
                        .when()
                        .get("/users");

        // Extract and print the response
        int statusCode = response.getStatusCode();
        System.out.println("Status Code" + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);
    }

    @Test
    public void testGetAllResponse(){
        given()
                .when()
                .get(BASE_URI + RESOURCE_PATH)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
    @Test
    public void listAllProducts(){
        RestAssured.baseURI = BASE_URI;
        // Perform GET all items api request
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(RESOURCE_PATH);

        // Extract and print the response
        int statusCode = response.getStatusCode();
        System.out.println("Status Code" + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);
    }

}
