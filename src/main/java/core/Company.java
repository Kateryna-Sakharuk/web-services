package core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
    private Geo geo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
