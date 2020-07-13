package ru.lanit.framework.steps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Console;


public class ConsoleTest {
    private final Console console = new Console();

    @DataProvider
    public Object[][] numberTestEmptyExpression() {
        return new Object[][]{
                {""},
        };
    }

    @DataProvider
    public Object[][] numberTestNotEmptyExpression() {
        return new Object[][]{
                {"2+3-1", "2 +3- 1"},
                {"7*13+-1", " 7 * 13+ -1"}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "numberTestEmptyExpression")
    void testEmptyExpression(String string) {
        console.getPreparedString(string);
    }

    @Test(dataProvider = "numberTestNotEmptyExpression")
    void testNotEmptyExpression(String result, String expression) {
        Assert.assertEquals(console.getPreparedString(expression), result);
    }


}
