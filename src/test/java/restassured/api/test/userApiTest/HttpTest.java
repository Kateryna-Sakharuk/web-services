package restassured.api.test.userApiTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

public class HttpTest extends BaseApiTest {
private final Specification createNewUser = new Specification();
    @Test
    public void checkStatusCodeTest() {
        Response response = createNewUser.getResource("1");
    }

    @Test
    public void checkResponseContentTest() {
        Response response = createNewUser.getResource("");
        int usersCount = response.jsonPath().getList("$").size();

        Assert.assertEquals(usersCount, 10, "Content of the response body is NOT the array of 10 users");

    }

    @Test
    public void checkResponseHeaderTest() {
        Response response = createNewUser.getResource("");

        Assert.assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"),
                "Content-Type header is missing from the received response");
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8",
                "Invalid Content-Type header value");
    }
}
