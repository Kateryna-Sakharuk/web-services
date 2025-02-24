package restassured.api.test.petApiTest;

import io.restassured.response.Response;
import models.pet.Pet;
import models.testDataGenerator.PetTestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

import static models.testDataGenerator.PetTestDataGenerator.createNewPet;

public class PetCrudTest extends BaseApiTest {
    private Specification petApiClient = new Specification();
    private Pet newPet = createNewPet();
    private Pet updatedPet = PetTestDataGenerator.getGeneratedPetWithFullData();
    private String petId;

    @Test(priority = 1)
    public void createPet() {
        Response response = petApiClient.postResource(newPet);
        Pet responsePet = response.as(Pet.class);
        petId = responsePet.getId().toString();
        assertPetDetails(responsePet, newPet);
    }

    @Test(priority = 2)
    public void getPet() {
        Assert.assertNotNull(petId, "Pet ID is null! Ensure createPet() runs first.");
        Response response = petApiClient.getResource(petId);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getId().toString(), petId, "Pet ID mismatch!");
    }

    @Test(priority = 3)
    public void updatePet() {
        updatedPet.setId(Integer.parseInt(petId));
        petApiClient.putResource(updatedPet);
        Response response = petApiClient.getResource(petId);
        Pet responsePet = response.as(Pet.class);
        assertPetDetails(responsePet, updatedPet);
    }

    @Test(priority = 4)
    public void deletePet() {
        petApiClient.deleteResource(petId);
        Response response = petApiClient.getResource(petId);
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
