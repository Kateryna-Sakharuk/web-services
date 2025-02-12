package core;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
