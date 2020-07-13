package ru.lanit.framework.steps;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Calculator;

public class CalculatorTest {

    @DataProvider
    public Object[][] numberProviderForSum() {
        return new Object[][]{
                {"5", "3 + 2"},
                {"3", "1 + 2"}

        };
    }

    @DataProvider
    public Object[][] numberProviderForMinus() {
        return new Object[][]{
                {"1", "3 - 2"},
                {"-1", "1 - 2"}

        };
    }

    @DataProvider
    public Object[][] numberProviderForDivision() {
        return new Object[][]{
                {"1.000000", "3 / 3"},
                {"4.000000", "8 / 2"}

        };
    }

    @DataProvider
    public Object[][] numberProviderForMultiplication() {
        return new Object[][]{
                {"15241578750190521", "123456789*123456789"},
                {"16", "8*2"}
        };
    }

    @DataProvider
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {"8", "2*4"},
                {"15", "8*2"}
        };
    }

    @Test(dataProvider = "numberProviderForSum")
    public void testSum(String result, String expression) {
        Assert.assertEquals(Calculator.calculateExpression(expression), result, "Wrong result");
    }


    @Test(dataProvider = "numberProviderForMinus")
    public void testMinus(String result, String expression) {
        Assert.assertEquals(Calculator.calculateExpression(expression), result, "Wrong result");
    }

    @Test(dataProvider = "numberProviderForDivision")
    public void testDivision(String result, String expression) {
        Assert.assertEquals(Calculator.calculateExpression(expression), result, "Wrong result");
    }

    @Test(dataProvider = "numberProviderForMultiplication")
    public void testMultiplication(String result, String expression) {
        Assert.assertEquals(Calculator.calculateExpression(expression), result, "Wrong result");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegative(String result, String expression) {
        Assert.assertNotEquals(Calculator.calculateExpression(expression), result, "Values are equal!");
    }
}
