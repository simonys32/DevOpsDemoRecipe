package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecipeTest {

    @Test
    public void testRecipe() {
        var recipe1 = new Recipe(1, "Pasta", "Leckere Pasta", "Nudeln, Sauce", "Kochen", "20 Min", "2", "Hauptgericht");
        assertEquals("Pasta", recipe1.getTitle());
        assertEquals("Leckere Pasta", recipe1.getDescription());
        assertEquals(1, recipe1.getId());
        assertEquals("Nudeln, Sauce", recipe1.getIngredients());
        assertEquals("20 Min", recipe1.getCookingTime());
        assertEquals("Hauptgericht", recipe1.getCategory());
    }

}
