package restassured.api.user;

import models.datagenerator.TestDataGenerator;
import models.user.User;
import org.testng.annotations.Test;
import rest.RequestSpecification;
import restassured.api.BaseApiTest;


public class CreateUserTest extends BaseApiTest {
    private final RequestSpecification createNewUser = new RequestSpecification();
    private final User newUser = TestDataGenerator.createNewUser();

    @Test
    public void createUserTest() {
        createNewUser.postResource(newUser);
    }
}
