package models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private Address(AddressBuilder builder) {
        this.street = builder.street;
        this.suite = builder.suite;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
        this.geo = builder.geo;
        this.additionalProperties = builder.additionalProperties;
    }

    public static class AddressBuilder {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
        private Map<String, Object> additionalProperties = new HashMap<>();

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder suite(String suite) {
            this.suite = suite;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressBuilder geo(Geo geo) {
            this.geo = geo;
            return this;
        }

        public AddressBuilder additionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }
}