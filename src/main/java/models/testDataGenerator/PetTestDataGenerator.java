package models.testDataGenerator;

import models.pet.Category;
import models.pet.Pet;
import models.pet.Status;
import models.pet.Tag;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PetTestDataGenerator {
    public static Pet createNewPet() {
        return Pet.builder()
                .id(45)
                .name("Sauron")
                .photoUrls(Arrays.asList("http:/doggy", "http:/dodggy"))
                .category(Category.builder()
                        .id(1)
                        .name("Cats")
                        .build())
                .tags(Collections.singletonList(new Tag(1, "Maine Coon")))
                .status(Status.available)
                .build();
    }

    public static Pet getGeneratedPetWithFullData() {
        return Pet.builder()
                .id(getRandomInt())
                .name(getRandomString())
                .photoUrls(Arrays.asList(getRandomString(), getRandomString()))
                .category(Category.builder().id(getRandomInt()).name(getRandomString()).build())
                .tags(Arrays.asList(Tag.builder().id(getRandomInt()).name(getRandomString()).build(),
                        Tag.builder().id(getRandomInt()).name(getRandomString()).build()))
                .status(Status.available)
                .build();
    }

    public static Pet getGeneratedPetWithMinimumData() {
        return Pet.builder()
                .id(getRandomInt())
                .name(getRandomString())
                .build();
    }

    private static Integer getRandomInt() {
        return new Random().nextInt((65536) - 32768);
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }
}
