package models.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private Status status;
    private List<Tag> tags = new ArrayList<>();

}
