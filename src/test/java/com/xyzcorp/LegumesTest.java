package com.xyzcorp;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LegumesTest {

    @Test
    public void testGetLegumesZucchini(){

        given()
        .relaxedHTTPSValidation()
        .accept(ContentType.JSON)
        .when()
        .get("https://staging.tiered-planet.net/mild-temper/legumes")
        .then()
        .assertThat()
        .body("[1].description", equalTo("Summer squash"));
    }


    @Test
    public void testGetLegumesCarrot(){

        given()
        .relaxedHTTPSValidation()
        .accept(ContentType.JSON)
        .when()
        .get("https://staging.tiered-planet.net/mild-temper/legumes")
        .then()
        .assertThat()
        .body("[0].name", equalTo("Carrot"));
    }



   
    
}
