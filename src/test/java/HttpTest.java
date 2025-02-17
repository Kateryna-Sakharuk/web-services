import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestSpecification.UserSpecification;

public class HttpTest extends BaseApiTest {
private final UserSpecification createNewUser = new UserSpecification();
    @Test
    public void checkStatusCodeTest() {
        Response response = createNewUser.getUser("1");
    }

    @Test
    public void checkResponseContentTest() {
        Response response = createNewUser.getUser("");
        int usersCount = response.jsonPath().getList("$").size();

        Assert.assertEquals(usersCount, 10, "Content of the response body is NOT the array of 10 users");

    }

    @Test
    public void checkResponseHeaderTest() {
        Response response = createNewUser.getUser("");

        Assert.assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"),
                "Content-Type header is missing from the received response");
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8",
                "Invalid Content-Type header value");
    }
}
