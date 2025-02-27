package restassured.api.test.petApiTest;

import io.restassured.response.Response;
import models.pet.Pet;
import models.testDataGenerator.PetTestDataGenerator;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

public class PetCrudTest extends BaseApiTest {
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

    @Test(priority = 1)
    public void createPet() {
        Response response = petApiClient.postResource(newPet);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code on pet creation");

        Pet responsePet = response.as(Pet.class);
        petId = responsePet.getId().toString();
        assertPetDetails(responsePet, newPet);
    }

    @Test(priority = 2)
    public void getPet() {
        Assert.assertNotNull(petId, "Pet ID is null! Ensure createPet() runs first.");
        Response response = petApiClient.getResource(petId);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code when retrieving pet");

        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getId().toString(), petId, "Pet ID mismatch!");
    }

    @Test(priority = 3)
    public void updatePet() {
        updatedPet.setId(Integer.parseInt(petId));
        Response response = petApiClient.putResource(updatedPet);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code on pet update");

        Pet responsePet = response.as(Pet.class);
        assertPetDetails(responsePet, updatedPet);

        Response updatePet = petApiClient.getResource(petId);
        Assert.assertEquals(updatePet.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code when getting updated pet");

    }

    @Test(priority = 4)
    public void deletePet() {
        Response deletePet = petApiClient.deleteResource(petId);
        Assert.assertEquals(deletePet.getStatusCode(), HttpStatus.SC_OK, "Expected 200 status code when deleted pet");

        Response response = petApiClient.getResource(petId);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 status code when retrieving a deleted pet");

        String errorMessage = response.jsonPath().getString("message");
        Assert.assertEquals(errorMessage, "Pet not found", "Expected error message 'Pet not found'");
    }

    private void assertPetDetails(Pet responsePet, Pet expectedPet) {

        Assert.assertEquals(responsePet.getId(), expectedPet.getId(), "Pet ID mismatch!");
        Assert.assertEquals(responsePet.getName(), expectedPet.getName(), "Pet Name mismatch!");
        Assert.assertEquals(responsePet.getPhotoUrls(), expectedPet.getPhotoUrls(), "Photo URLs mismatch!");
        Assert.assertEquals(responsePet.getCategory(), expectedPet.getCategory(), "Category mismatch!");
        Assert.assertEquals(responsePet.getTags(), expectedPet.getTags(), "Tags mismatch!");
        Assert.assertEquals(responsePet.getStatus(), expectedPet.getStatus(), "Status mismatch!");
    }
}
