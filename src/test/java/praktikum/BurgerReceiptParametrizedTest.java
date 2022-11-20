package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class BurgerReceiptParametrizedTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private String bunName;
    private IngredientType ingredientType;
    private String ingredientName;
    private float burgerPrice;
    private String expectedReceipt;

    public BurgerReceiptParametrizedTest(String bunName, IngredientType ingredientType, String ingredientName, float burgerPrice, String expectedReceipt) {
        this.bunName = bunName;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.burgerPrice = burgerPrice;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] receiptParam() {
        return new Object[][]{
                {"", IngredientType.FILLING, "Лосось", 0.0f,
                        "(====  ====)" + System.lineSeparator()
                                + "= filling Лосось =" + System.lineSeparator()
                                + "(====  ====)" + System.lineSeparator()
                                + System.lineSeparator()
                                + "Price: 0,000000"
                                + System.lineSeparator()},
                {"Рисовая булочка", IngredientType.SAUCE, "Паштет из тунца", 0.1f,
                        "(==== Рисовая булочка ====)" + System.lineSeparator()
                                + "= sauce Паштет из тунца =" + System.lineSeparator()
                                + "(==== Рисовая булочка ====)" + System.lineSeparator()
                                + System.lineSeparator()
                                + "Price: 0,100000"
                                + System.lineSeparator()},
                {"Лист салата", IngredientType.FILLING, "", 1000f,
                        "(==== Лист салата ====)" + System.lineSeparator()
                                + "= filling  =" + System.lineSeparator()
                                + "(==== Лист салата ====)" + System.lineSeparator()
                                + System.lineSeparator()
                                + "Price: 1000,000000"
                                + System.lineSeparator()}

        };
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        MockitoAnnotations.openMocks(this);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);
        String actualReceipt = burger.getReceipt();
        System.out.println(actualReceipt);
        Assert.assertEquals("вернулся ли рецепт бургера", expectedReceipt, actualReceipt);
    }

}
