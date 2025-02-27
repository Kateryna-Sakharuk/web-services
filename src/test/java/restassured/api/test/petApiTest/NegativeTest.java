package restassured.api.test.petApiTest;

import io.restassured.response.Response;
import models.pet.Pet;
import models.testDataGenerator.PetTestDataGenerator;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NegativeTest extends BaseApiTest {
    static final Logger logger = LogManager.getLogger(NegativeTest.class);
    private Specification petApiClient;
    private Pet newPet;
    private Pet updatedPet;
    private String petId;

    @BeforeClass
    public void setUpTestData() {
        petApiClient = new Specification();
        newPet = PetTestDataGenerator.createNewPet();
        updatedPet = PetTestDataGenerator.getGeneratedPetWithFullData();
    }

    @Test
    public void deletePetNegativeTest() throws InterruptedException {
        logger.info("Create a new pet");

        Response response = petApiClient.postResource(newPet);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Expected status 200 on create pet");

        Pet responsePet = response.as(Pet.class);
        petId = responsePet.getId().toString();

//        Thread.sleep(5000);
        Assert.assertEquals(petApiClient.getResource(petId).getStatusCode(), HttpStatus.SC_OK, "Expected status 200 for GET pet method");


        logger.info("Delete the pet for the first time");
//        Thread.sleep(5000);
        Response firstDeleteResponse = petApiClient.deleteResource(petId);
        Assert.assertEquals(firstDeleteResponse.getStatusCode(), HttpStatus.SC_OK, "Expected status 200 on first deletion");

        logger.info("Attempt to delete the pet a second time");
        Response secondDeleteResponse = petApiClient.deleteResource(petId);

//        Thread.sleep(5000);
        Assert.assertEquals(secondDeleteResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Expected status 404 on second deletion");

    }

    @Test
    public void testSendIncorrectJson() throws IOException {
        String filePath = "src/test/resources/data/json/incorrect.json";
        String incorrectJsonPayload = Files.readString(Paths.get(filePath));

        logger.info("Sending incorrect JSON payload from file: " + filePath);
        logger.info("Payload content: " + incorrectJsonPayload);

        Response response = petApiClient.postResource(incorrectJsonPayload);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR,
                "Expected 500 Server Error for incorrect JSON payload");
    }
}

