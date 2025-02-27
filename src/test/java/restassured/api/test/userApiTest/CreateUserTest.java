package restassured.api.test.userApiTest;

import models.testDataGenerator.TestDataGenerator;
import models.user.User;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;


public class CreateUserTest extends BaseApiTest {
    private final Specification createNewUser = new Specification();
    private final User newUser = TestDataGenerator.createNewUser();

    @Test
    public void createUserTest() {
        createNewUser.postResource(newUser);
    }
}
