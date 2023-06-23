package de.thi.Resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Disabled
public class startRegistrationProcessResourceTest {

    @Test
    public void testStartRegistrationProcessResourceUser() {

        String userEvent = """
                                
                {
                  "id" : "53b4bcaf-0c31-49f4-951f-c4e29fd1c800",
                  "time" : 1686842253378,
                  "type" : "REGISTER",
                  "realmId" : "36382947-8ffa-4a8a-9881-2b7eeb84f800",
                  "clientId" : "security-admin-console",
                  "userId" : "85ac675c-bcec-468f-aeb7-896f3f45e498",
                  "sessionId" : null,
                  "ipAddress" : "172.17.0.1",
                  "error" : null,
                  "details" : {
                    "auth_method" : "openid-connect",
                    "auth_type" : "code",
                    "register_method" : "form",
                    "last_name" : "userEventTest_firstname",
                    "redirect_uri" : "http://localhost:8543/admin/quarkus/console/",
                    "first_name" : "userEventTest",
                    "code_id" : "5a24c912-6467-42fb-bae4-71e35e601c41",
                    "email" : "hus4725@thi.de",
                    "username" : "userEventTest"
                  }
                }
                               
                                
                """;

        String adminEvent = """
                
                {
                  "id" : "1ed5afdf-7bd3-4ccb-950e-e9a4be0aee54",
                  "time" : 1686842125072,
                  "realmId" : "36382947-8ffa-4a8a-9881-2b7eeb84f800",
                  "authDetails" : {
                    "realmId" : "0573e4b3-be32-45a5-b4eb-c8bf2d69fffa",
                    "clientId" : "b7521d13-6c2a-40e7-b2ec-218507c61957",
                    "userId" : "58fc167f-d9cd-48ca-bdd3-7e440b0e9a51",
                    "ipAddress" : "172.17.0.1"
                  },
                  "resourceType" : "USER",
                  "operationType" : "CREATE",
                  "resourcePath" : "users/b7910381-edbb-491f-be42-2947e353373b",
                  "representation" : "{\\"username\\":\\"adminEventTest\\",\\"enabled\\":true,\\"emailVerified\\":false,\\"firstName\\":\\"adminEventTest_firstname\\",\\"lastName\\":\\"adminEventTest_lastname\\",\\"email\\":\\"hus4725@thi.de\\",\\"requiredActions\\":[],\\"groups\\":[]}",
                  "error" : null,
                  "resourceTypeAsString" : "USER"
                }
                
                """;


        given()
                .body(userEvent)
                .header("Content-Type", "application/json")
                .when()
                .post("/startRegistrationProcess/User")
                .then()
                .log().all();

        given()
                .body(adminEvent)
                .header("Content-Type", "application/json")
                .when()
                .post("/startRegistrationProcess/Admin")
                .then()
                .log().all();



    }
}
