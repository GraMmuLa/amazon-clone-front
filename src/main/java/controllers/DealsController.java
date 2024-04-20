package controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class DealsController {
    @GetMapping("/deals")
    public ModelAndView deals() {

        ModelAndView deals = new ModelAndView("deals");

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("http://localhost:8081/products/all", String.class);

//        ArrayList<Product> products = new ArrayList<>();
//        JSONArray jsonArray = new JSONArray(result);
//        for(Object jsonObject : jsonArray) {
//            products.add(new Product((JSONObject) jsonObject));
//        }

//        deals.addObject("products", products);

        return deals;
    }
}
