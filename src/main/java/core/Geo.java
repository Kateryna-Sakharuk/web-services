package core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
@Builder(toBuilder = true)
public class Geo {

    private String lat;
    private String lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}