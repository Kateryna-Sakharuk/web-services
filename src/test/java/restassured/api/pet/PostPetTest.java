package restassured.api.pet;

import models.pet.Pet;
import models.datagenerator.PetTestDataGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.RequestSpecification;
import restassured.api.BaseApiTest;

public class PostPetTest extends BaseApiTest {
    private RequestSpecification createNewPet;
    private Pet newPet;
    private Pet minDataPet;
    private Pet fullDataPet;

    @BeforeClass
    public void initTestData() {
        createNewPet = new RequestSpecification();
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
