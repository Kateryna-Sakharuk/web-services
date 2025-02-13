import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HttpTest {
    String BASE_URI= "https://jsonplaceholder.typicode.com/users";

    @Test
    public void checkStatusCodeTest() {
        given()
                .queryParam("id", 1)
                .when()
                .get(BASE_URI)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void checkResponseContentTest() {
        given()
                .when()
                .get(BASE_URI)
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("size()", equalTo(10));
    }

    @Test
    public void checkResponseHeaderTest() {
        given()
                .when()
                .get(BASE_URI)
                .then()
                .log()
                .headers()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .header("Content-type", equalTo("application/json; charset=utf-8"));
    }
}
