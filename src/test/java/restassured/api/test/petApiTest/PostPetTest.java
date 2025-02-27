package restassured.api.test.petApiTest;

import models.pet.Pet;
import models.testDataGenerator.PetTestDataGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestSpecification.Specification;
import restassured.api.test.BaseApiTest;

public class PostPetTest extends BaseApiTest {
    private Specification createNewPet;
    private Pet newPet;
    private Pet minDataPet;
    private Pet fullDataPet;

    @BeforeClass
    public void initTestData() {
        createNewPet = new Specification();
        newPet = PetTestDataGenerator.createNewPet();
        minDataPet = PetTestDataGenerator.getGeneratedPetWithMinimumData();
        fullDataPet = PetTestDataGenerator.getGeneratedPetWithFullData();
    }

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
