import core.TestDataGenerator;
import core.User;
import org.testng.annotations.Test;
import requestSpecification.UserSpecification;

public class CreateUserTest extends BaseApiTest {
    private final UserSpecification createNewUser = new UserSpecification();
    private final User newUser = TestDataGenerator.createNewUser();

    @Test
    public void createUserTest() {
        createNewUser.postUser(newUser);
    }
}
