package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "TestName", 1f);

    @Test
    public void isGetPriceReturnIngredientPrice() {
        float returnedPrice = ingredient.getPrice();
        assertEquals(1f, returnedPrice, 0.0f);
    }

    @Test
    public void isGetNameReturnIngredientName() {
        String returnedName = ingredient.getName();
        assertEquals("TestName", returnedName);
    }

    @Test
    public void isGetTypeReturnIngredientType() {
        IngredientType returnedType = ingredient.getType();
        assertEquals(IngredientType.FILLING, returnedType);
    }
}
