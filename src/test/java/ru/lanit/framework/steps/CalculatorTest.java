package ru.lanit.framework.steps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Calculator;

public class CalculatorTest {

    @DataProvider
    public Object[][] numberProviderForSum(){
        return new Object[][]{
                {5,3,2},
                {3.27,3,0.27},
                {-8.769,-3.040,-5.729}
        };
    }

    @DataProvider
    public Object[][] numberProviderForMinus(){
        return new Object[][]{
                {1,3,2},
                {2.73,3,0.27},
                {8.769,3.040,-5.729}
        };
    }

    @DataProvider
    public Object[][] numberProviderForMulti(){
        return new Object[][]{
                {6,3,2},
                {0.81,3,0.27},
                {17.41616,-3.040,-5.729}
        };
    }

    @DataProvider
    public Object[][] numberProviderForDivisionTest(){
        return new Object[][]{
                {1.5,3.0,2.0},
                {6.0,3,0.5},
                {6.0,-3.6,-0.6}
        };
    }

    @Test(dataProvider = "numberProviderForSum")
    public void testSum(Number result,Number number1, Number number2){
        Assert.assertEquals(Calculator.calculateExpression(number1,number2),result,"Wrong result");
    }

    @Test(dataProvider = "numberProviderForMinus")
    public void testMinus(Number result,Number number1, Number number2){
        Assert.assertEquals(Calculator.calculateExpression(number1,number2),result,"Wrong result");
    }

    @Test(dataProvider = "numberProviderForMulti")
    public void testMulti(Number result,Number number1, Number number2){
        Assert.assertEquals(Calculator.calculateExpression(number1, number2),result,"Wrong result");
    }

    @Test(dataProvider = "numberProviderForDivisionTest")
    public void testDivision(Number result,Number number1, Number number2){
        Assert.assertEquals(Calculator.calculateExpression(number1, number2),result,"Wrong result");
    }

}
