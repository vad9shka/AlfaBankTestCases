package Tests;

import Base.Methods;
import org.testng.annotations.Test;

/**
 * Created by Администратор on 30.03.2016.
 */
public class Test1 extends Methods {

    @Test
    public void testCase1() {
        marketMethod("Маркет");
        electronicsSection("Электроника");
        tvSelect("Телевизоры");
        largeSearch();
        priceForm("20000");
        selectModelRefactMethod("Samsung", "LG");
        applyFilterButton("Применить");
        sumOfElements();
    }
}
