package restassured.api.test.petApiTest;

import models.testDataGenerator.PetTestDataGenerator;
import models.pet.Pet;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

public class PostPetTest extends BaseApiTest {
    private final Specification createNewPet = new Specification();
    private final Pet newPet = PetTestDataGenerator.createNewPet();
    private final Pet minDataPet = PetTestDataGenerator.getGeneratedPetWithMinimumData();
    private final Pet fullDataPet = PetTestDataGenerator.getGeneratedPetWithFullData();

    @Test
    public void createCreateNewPet() {
        createNewPet.postResource(newPet);
    }

    @Test
    public void createMinDataPet() {
        createNewPet.postResource(minDataPet);
    }

    @Test
    public void createFullDataPet() {
        createNewPet.postResource(fullDataPet);
    }
}
