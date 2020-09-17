package org.acme.rest.client

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class CountriesResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/country")
          .then()
             .statusCode(200)
             .body(`is`("hello"))
    }

}