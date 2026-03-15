package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class RecipeControllerTest {

    @Test
    public void testCreate() {
        var controller = new RecipeController();
        var recipe = new Recipe(1, "Pasta", "Desc", "Zutaten", "Zubereitung", "20 Min", "2", "Hauptgericht");
        controller.createRecipe(1, recipe);
        assertEquals(1, controller.recipe().size());
        controller.createRecipe(recipe);
        assertEquals(2, controller.recipe().size());
    }

    @Test
    public void testDelete() {
        var controller = new RecipeController();
        var recipe = mock(Recipe.class);
        when(recipe.getId()).thenReturn(1);
        controller.createRecipe(recipe);
        assertEquals(1, controller.recipe().size());
        var result = controller.getRecipe(1);
        assertEquals(1, result.getId());
        controller.deleteRecipe(1);
        assertEquals(0, controller.recipe().size());
    }

}
