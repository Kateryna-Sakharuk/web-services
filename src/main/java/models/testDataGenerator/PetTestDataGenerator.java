package models.testDataGenerator;

import models.pet.Category;
import models.pet.Pet;
import models.pet.Status;
import models.pet.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import properties.PropertyReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PetTestDataGenerator {
    public static Pet createNewPet() {
        return Pet.builder()
                .id(Integer.parseInt(PropertyReader.getProperty("pet.id")))
                .name(PropertyReader.getProperty("pet.name"))
                .photoUrls(Arrays.asList(PropertyReader.getProperty("pet.photoUrls").split(",")))
                .category(Category.builder()
                        .id(Integer.parseInt(PropertyReader.getProperty("pet.category.id")))
                        .name(PropertyReader.getProperty("pet.category.name"))
                        .build())
                .tags(Collections.singletonList(new Tag(
                        Integer.parseInt(PropertyReader.getProperty("pet.tag.id")),
                        PropertyReader.getProperty("pet.tag.name"))))
                .status(Status.valueOf(PropertyReader.getProperty("pet.status").toLowerCase()))
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
