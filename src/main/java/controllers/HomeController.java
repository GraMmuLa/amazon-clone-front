package controllers;

import entities.Subcategory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class HomeController {
    @GetMapping("/index")
    public ModelAndView index() {

        ModelAndView index = new ModelAndView("index");

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8081/subcategory/all", String.class);

        ArrayList<Subcategory> subcategories = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(result);
        for(Object jsonObject : jsonArray) {
            subcategories.add(new Subcategory((JSONObject) jsonObject));
        }

        index.addObject("subcategories", subcategories);

        return index;
    }
}
