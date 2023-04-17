// package de.thi;

// import de.thi.beans.User;
// import de.thi.UserUpdate;
// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import javax.inject.Inject;
// import javax.transaction.Transactional;
// import java.time.LocalDateTime;

// import static io.restassured.RestAssured.given;
// import static io.restassured.RestAssured.when;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.Matchers.equalTo;
// import static org.hamcrest.Matchers.greaterThan;

// @QuarkusTest
// public class UserUpdateApiTests {
//     @Inject
//     User user;
//     UserUpdate userUpdtae;

//     @BeforeEach
//     @Transactional
//     public void setup() {
//         user.deleteAll();
//     }

//     @Test
//     @DisplayName("Update User")
//     public void shouldAddAnEntry() {
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(new UserUpdate("Kermit", "test@demo.de", "1234", "+49123456789", "19.09.1999", LocalDateTime.now()))
//                 .post("user/update")
//                 .then()
//                 .statusCode(204);
//     }
// }
