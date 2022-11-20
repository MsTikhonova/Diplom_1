package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void getPriceReturnsCorrectBurgerPrice() {
        float burgerTestPrice = 12.4f;
        Mockito.when(bun.getPrice()).thenReturn(1.2f);
        Mockito.when(ingredient.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float returnedPrice = burger.getPrice();
        assertEquals(burgerTestPrice, returnedPrice, 0.0f);
    }

}
