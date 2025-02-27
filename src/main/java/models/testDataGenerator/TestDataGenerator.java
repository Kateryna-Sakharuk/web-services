package models.testDataGenerator;

import models.user.Address;
import models.user.Company;
import models.user.Geo;
import models.user.User;

public class TestDataGenerator {
    public static User createNewUser() {
        Address address = new Address.AddressBuilder()
                .street("123 Main St")
                .suite("Apt 4B")
                .city("New York")
                .zipcode("10001")
                .geo(Geo.builder()
                        .lat("40.7128")
                        .lng("74.0060")
                        .build())
                .build();

        Company company = Company.builder()
                .name("Tech Corp")
                .catchPhrase("Innovating the Future")
                .bs("Tech business solutions")
                .build();

        return User.builder()
                .id(11)
                .name("James")
                .username("Morrison")
                .email("tom_morrison@gmail.com")
                .address(address)
                .phone("123-456-7890")
                .website("www.jamesmorrison.com")
                .company(company)
                .build();
    }
}
