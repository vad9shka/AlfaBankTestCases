package Tests;

import Base.Methods;
import org.testng.annotations.Test;

/**
 * Created by Администратор on 10.04.2016.
 */
public class Test2 extends Methods{
    @Test
    public void testCase2(){
        marketMethod("Маркет");
        electronicsSection("Электроника");
        tvSelect("Наушники");
        largeSearch();
        priceForm("5000");
        selectModelRefactMethod("Beats", "nul");
        applyFilterButton("Применить");
        sumOfElements();

    }

}
