package com.xyzcorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.json.JSONObject;

public class FruitTest {
    //Rest-Assured
    // [{"description":"Winter fruit","name":"Apple"},
    //  {"description":"Tropical fruit","name":"Pineapple"}]
    @Test
    public void testGetFruits() {
        given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .when()
                .get("https://staging.tiered-planet.net/mild-temper/fruits")
                .then()
                .assertThat()
                .body("[0].description", equalTo("Winter fruit"));
    }

    @Test
    public void testGetFruits2() {
        given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .when()
                .get("https://staging.tiered-planet.net/mild-temper/fruits")
                .then()
                .assertThat()
                .body("[1].description", equalTo("Tropical fruit"));
    }

    @Test
    public void testPostNewFruit(){
        JSONObject bananaObject = new JSONObject()
                .put("description", "a delicious banana")
                .put("name", "banana");

        System.out.println("bananaObject");

        given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON) //I hope you accept JSON  
                .contentType(ContentType.JSON) // My post is JSON
                .body(bananaObject.toString())
                .when()
                .post("https://staging.tiered-planet.net/mild-temper/fruits")
                .then()
                .assertThat()
                .statusCode(200); // HTTP works in status code. 200 means okay 

                
    }



}
