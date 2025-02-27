package models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Geo {
    private String lat;
    private String lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}