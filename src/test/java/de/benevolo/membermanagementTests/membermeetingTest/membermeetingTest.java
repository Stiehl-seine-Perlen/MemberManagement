package de.benevolo.membermanagementTests.membermeetingTest;

import de.benevolo.membermeetingmanagement.entities.Membermeeting;
import de.benevolo.membermeetingmanagement.repositories.MembermeetingRepositorie;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
//@TestHTTPEndpoint(MembermeetingService.class)
public class membermeetingTest {


    @Inject MembermeetingRepositorie membermeetingRepositorie;

    private String membermeeting1 = """
                  {       
                    "isClosed": true,
                    "membermeeting": {
                    "date": "2023-08-15",
                    "time": "14:00 Uhr",
                    "location": "Verein",
                    "isClosed": true,
                    "ownedByAssociationId": 5,
                    "when": "2022-03-10T12:15:50"
                },
                "membermeetingMsg": "Begrüßung, Themenvorstellung, Besprechung, Fragen, Verabschiedung"
                }
                				""";

    private String membermeeting2 = """
                  {       
                    "isClosed": false,
                    "membermeeting": {
                    "date": "2023-10-09",
                    "time": "15:00 Uhr",
                    "location": "Gasthaus",
                    "isClosed": false,
                    "ownedByAssociationId": 3,
                    "when": "2022-03-10T12:15:50"
                 },
                    "membermeetingMsg": "Begrüßung, Themenvorstellung, Besprechung, Fragen, Verabschiedung, Afterparty"
                }
                				""";

    private String membermeeting3 = """
                  {       
                    "isClosed": true,
                    "date": "2023-10-09",
                    "time" : "16:00 Uhr",
                    "location": "Verein",
                    "ownedByAssociationId": 3,
                    "agenda": "Begrüßung, Themenvorstellung, Besprechung, Fragen, Verabschiedung",
                    "when": "2022-03-10T12:15:50"
                  }
                				""";

    @BeforeEach
    @Transactional
    public void emptyTheDatabase() {
        membermeetingRepositorie.deleteAll();
    }

    @Test
    public void shouldReturnEmptyList() {
        when()
                .get("/membermeeting/listAllMembermeeting")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void shouldPersistTwoMembermeetings() {

        persistTwoMembermeetings();

        //then
        List<Membermeeting> list = membermeetingRepositorie.listAll();
        assertThat(list, hasSize(2));

    }

    @Test
    public void ShouldUpdateEvent(){
                given()
                .body(membermeeting1)
                .contentType(ContentType.JSON)
                .when()
                .post("/CreateMemberMeeting")
                .then()
                .statusCode(201);

                given()
                .body(membermeeting3)
                .contentType(ContentType.JSON)
                .when()
                .put("/membermeeting/update/1")
                .then()
                .statusCode(200);
    }

    public void persistTwoMembermeetings(){
                given()
                .body(membermeeting1)
                .contentType(ContentType.JSON)
                .when()
                .post("/CreateMemberMeeting")
                .then()
                .statusCode(201);

                given()
                .body(membermeeting2)
                .contentType(ContentType.JSON)
                .when()
                .post("/CreateMemberMeeting")
                .then()
                .statusCode(201);
            }
}
