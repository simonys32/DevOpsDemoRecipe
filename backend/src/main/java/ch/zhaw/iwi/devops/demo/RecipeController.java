package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RecipeController {

    private Map<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.recipes.put(1,new Recipe(1, "Spaghetti Bolognese", "Klassisches Pastagericht",
                "500g Spaghetti, 400g Hackfleisch, 1 Dose Tomaten, 1 Zwiebel, 2 Knoblauchzehen, Olivenöl, Salz, Pfeffer",
                "Zwiebel und Knoblauch anbraten, Hackfleisch dazu, Tomaten rein und 20 Min köcheln lassen",
                "30 Min", "4", "Hauptgericht"));
        this.recipes.put(2, new Recipe(2, "Caesar Salad", "Salat mit Dressing",
                "1 Romana-Salat, Parmesan, Croutons, Sardellenfilets, 1 Eigelb, Zitronensaft, Olivenöl",
                "Dressing mixen, Salat waschen, alles zusammen anrichten",
                "15 Min", "2", "Vorspeise"));
        this.recipes.put(3,new Recipe(3, "Schokoladenkuchen", "Einfacher Schoggi-Kuchen",
                "200g Schokolade, 150g Butter, 150g Zucker, 4 Eier, 100g Mehl, 1 TL Backpulver",
                "Schokolade und Butter schmelzen, Eier und Zucker schaumig rühren, alles vermengen, 180 Grad 25 Min",
                "45 Min", "8", "Dessert"));
        this.recipes.put(4,new Recipe(4, "Tomatensuppe", "Schnelle Suppe",
                "1kg Tomaten, 1 Zwiebel, 2 Knoblauchzehen, 500ml Gemüsebrühe, Basilikum, Rahm",
                "Zwiebel und Knoblauch anbraten, Tomaten dazu, pürieren, mit Brühe auffüllen",
                "25 Min", "4", "Vorspeise"));
        this.recipes.put(5, new Recipe(5, "Poulet-Curry", "Curry mit Kokosmilch",
                "500g Pouletbrust, 1 Dose Kokosmilch, 2 EL Currypaste, 1 Paprika, 1 Zwiebel, Reis",
                "Poulet anbraten, Currypaste und Kokosmilch dazu, Gemüse rein, 15 Min köcheln",
                "35 Min", "4", "Hauptgericht"));
        System.out.println("Init Data");
    }

    @GetMapping("/services/recipe")
    public List<PathListEntry<Integer>> recipe() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var recipe : this.recipes.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(recipe.getId(), "recipeKey");
            entry.setName(recipe.getTitle());
            entry.getDetails().add(recipe.getCategory() + " - " + recipe.getCookingTime());
            entry.setTooltip(recipe.getDescription());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }

    @GetMapping("/services/recipe/{key}")
    public Recipe getRecipe(@PathVariable("key") Integer key) {
        return this.recipes.get(key);
    }

    @PostMapping("/services/recipe")
    public void createRecipe(@RequestBody Recipe recipe) {
        var newId = this.recipes.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        recipe.setId(newId);
        this.recipes.put(newId, recipe);
    }

    @PutMapping("/services/recipe/{key}")
    public void createRecipe(@PathVariable("key") Integer key, @RequestBody Recipe recipe) {
        recipe.setId(key);
        this.recipes.put(key, recipe);
    }

    @DeleteMapping("/services/recipe/{key}")
    public Recipe deleteRecipe(@PathVariable("key") Integer key) {
        return this.recipes.remove(key);
    }


}
