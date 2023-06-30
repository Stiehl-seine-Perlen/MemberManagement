package de.benevolo.MembershipServiceTests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import de.benevolo.member_management.membership.connectors.AssociationRestClient;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
// @TestHTTPEndpoint(MembermeetingService.class)

public class MembershipServiceTest {

    @Inject
    @RestClient
    AssociationRestClient associationRestClient;

    // Change the base URL here
    private static final String ORIGINAL_BASE_URL = baseURI;
    private static final String BASE_URL = "http://localhost:8083/";

    private String membership1 = """
              {
                    "membershipId": "99999",
                    "userId": "9999",
                    "associationRole": {
                        "associationRoleId": null,
                        "roleName": "Test",
                        "roleDescription": "Test",
                        "canTransaction": false,
                        "canAccount": false,
                        "canEvent": false
                    }
            }    """;

    private String membership2 = """
            {
                    "membershipId": null,
                    "userId": "9999",
                    "associationRole": {
                        "associationRoleId": null,
                        "roleName": "Test2",
                        "roleDescription": "Test2",
                        "canTransaction": true,
                        "canAccount": true,
                        "canEvent": true
                    }
            }    """;

    @Test
    public void shouldPersistTwoMemberships() {

        // Set the base URI using the BASE_URL
        baseURI = BASE_URL;
        System.out.println(BASE_URL);
        System.out.println(ORIGINAL_BASE_URL);

        Long id = (long) 9999;
        persistTwoMemberships();

        // then
        // associationRestClient.deleteMembership(id);

        given()
                .body(id)
                .contentType(ContentType.JSON)
                .when()
                .delete("deleteMembership/")
                .then()
                .statusCode(200);

     
        baseURI = ORIGINAL_BASE_URL;
    }

    public void persistTwoMemberships() {

        // Set the base URI using the BASE_URL
        baseURI = BASE_URL;

        given()
                .body(membership1)
                .contentType(ContentType.JSON)
                .when()
                .post("/addMembership")
                .then()
                .statusCode(400);

        given()
                .body(membership2)
                .contentType(ContentType.JSON)
                .when()
                .post("/addMembership")
                .then()
                .statusCode(200);

        
       // baseURI = ORIGINAL_BASE_URL;
    }
}
