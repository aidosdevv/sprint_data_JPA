package kz.bitlab.dataJPA.controller;

import kz.bitlab.dataJPA.model.Food;
import kz.bitlab.dataJPA.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;

    @GetMapping("/addfood")
    public String index() {
        return "add-food";
    }

    @PostMapping("/addfood")
    public String addFood(@RequestParam(name = "food_name") String name,
                          @RequestParam(name = "food_cal") int calories,
                          @RequestParam(name = "food_amount") int amount,
                          @RequestParam(name = "food_price") int price) {
        Food food = Food
                .builder()
                .name(name)
                .calories(calories)
                .amounts(amount)
                .price(price)
                .build();
        if (food != null) {
            foodRepository.save(food);
            return "redirect:/foods";
        }else{
            return "add-food?error";
        }
    }

    @PostMapping("/delete_food")
    public String deleteFood(@RequestParam(name = "id") Long id) {
        if (id != null) {
            foodRepository.deleteById(id);
            return "redirect:/foods";
        }else{
            return "redirect:/foods?error";
        }
    }

    @GetMapping("/foods")
    public String foods(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        return "foods";
    }

    @PostMapping("/updatefood")
    public String update_food(@RequestParam(name = "food_id") Long id,
                              @RequestParam(name = "food_name") String name,
                              @RequestParam(name = "food_cal") int calory,
                              @RequestParam(name = "food_amount") int amount,
                              @RequestParam(name = "food_price") int price) {
        Food food = foodRepository.findById(id).orElse(null);
        if (food != null) {
            food.setName(name);
            food.setCalories(calory);
            food.setAmounts(amount);
            food.setPrice(price);
            foodRepository.save(food);
            return "redirect:/foods";
        }else{
            return "redirect:/error";
        }
    }
}
