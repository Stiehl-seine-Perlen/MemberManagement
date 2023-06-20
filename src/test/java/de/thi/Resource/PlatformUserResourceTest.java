package de.thi.Resource;

import de.thi.repositories.PlatformUserRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class PlatformUserResourceTest {
    @Inject
    PlatformUserRepository platformUserRepository;

    private String platformUser1 = """
            {
              "name": "test1",
              "email": "test1@test.de"
            }
            """;

    private String platformUser2 = """
            {
              "name": "test2",
              "email": "test2@test.de"
            }
            """;

    @BeforeEach
    @Transactional
    public void emptyTheDatabase() {
        platformUserRepository.deleteAll();

    }

    @Test
    public void shouldReturnEmptyList() {
        when()
                .get("/users")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void shouldReturnAllPlatformUsers() {
        given()
                .body(platformUser1)
                .header("Content-Type", "application/json")
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(200);

        given()
                .body(platformUser2)
                .header("Content-Type", "application/json")
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(200);

        when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("", hasSize(2));
    }

    @Test
    public void shouldReturnRightId(){

        int id=0;

        // create new PlatformUser and extract id to variable
        id = given()
                .body(platformUser1)
                .header("Content-Type", "application/json")
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("id");

        given()
                .get("/users/"+id)
                .then()
                .statusCode(200)
                .log().all()
                .body("name", is("test1"))
                .body("email", is("test1@test.de"));

    }

}
