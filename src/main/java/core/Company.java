package core;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
