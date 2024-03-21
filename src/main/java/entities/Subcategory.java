package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Subcategory extends Entity {
    private String name;
    private Long categoryId;

    public Subcategory(Long id, String name, Long categoryId) {
        this.setId(id);
        this.name = name;
        this.categoryId = categoryId;
    }

    public Subcategory(JSONObject json) {
        setId(json.getLong("id"));
        this.name = json.getString("name");
        this.categoryId = json.getLong("categoryId");
    }

    public SubcategoryImage getImage() {
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject("http://localhost:8081/subcategoryImage/subcategory?id="+getId(), String.class);
        return new SubcategoryImage(new JSONObject(result));
    }
}
