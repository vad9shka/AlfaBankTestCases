package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 30.03.2016.
 */
public class Methods extends Config {

    WebElement webElem;

    public void marketMethod(String nameOfElement){

        webElem = driver.findElement(By.linkText(nameOfElement));
        webElem.click();

    }

    public void electronicsSection(String nameOfElement){

        webElem = driver.findElement(By.linkText(nameOfElement));
        webElem.click();

    }

    public void tvSelect(String nameOfElement){

        webElem = driver.findElement(By.linkText(nameOfElement));
        webElem.click();

    }

    public void largeSearch(){
        webElem = driver.findElement(By.className("black"));
        webElem.click();

    }

    public void priceForm(String price){
        webElem = driver.findElement(By.id("gf-pricefrom-var"));
        webElem.click();
        webElem.sendKeys(price);
    }

    //короткий метод нахождения веб-элементов, у которых одинаковое имя className
    public void selectModelRefactMethod(String model1, String model2){
        List<WebElement> element = driver.findElements(By.className("checkbox__label"));
        /*String model1 = "LG";
        String model2 = "Samsung";*/
        for(WebElement EL:element){
            if ((model1.equals(EL.getText())) || model2.equals(EL.getText())){
                EL.click();
            }
        }
    }

    //длинный метод нахождения веб-элементов, у которых одинаковое имя className
    public void selectModel(String model1, String model2){

        List<WebElement> element = driver.findElements(By.className("checkbox__label"));
        List<WebElement> elements = new ArrayList<WebElement>();
        List<String> textElem = new ArrayList<String>();
        /*String model1 = "LG";
        String model2 = "Samsung";*/

        for(WebElement EL:element){
            elements.add(EL);
            textElem.add(EL.getText());
        }

        Iterator<String> it1 = textElem.iterator();
        Iterator<WebElement> it2 = elements.iterator();

        int i = 0;
        while(it1.hasNext() && it2.hasNext()){
            String data = it1.next();
            it2.next();
            if(model1.equals(data) || model2.equals(data)){
                webElem = elements.get(i);
                webElem.click();
            }
            i++;
        }
    }

    public void applyFilterButton(String nameOfButton){
        /*webElem = driver.findElement(By.className("filter-panel-aside__apply"));
        webElem.click();*/
        List<WebElement> element = driver.findElements(By.className("button__text"));
        Actions action = new Actions(driver);
        for(WebElement EL:element){
            if(EL.getText().equals(nameOfButton)){
                action.moveToElement(EL).click().perform();
            }
        }
    }

    public void sumOfElements(){
        int sumOfElem = 10;
        List<WebElement> element = driver.findElements(By.className("snippet-card__header-text"));
        System.out.println("Всего элементов на странице: " + element.size());
        Assert.assertSame(sumOfElem, element.size(), "summ of elements is not true!");

        List<String> nameOfElem = new ArrayList<String>();

        for(WebElement EL:element){
            nameOfElem.add(EL.getText());
        }

        String nameElem = nameOfElem.get(0);

        searchElem(nameElem);

    }

    public void searchElem(String nameElem){
        webElem = driver.findElement(By.id("header-search"));
        webElem.click();
        webElem.sendKeys(nameElem);
        List<WebElement> element = driver.findElements(By.className("button__text"));
        List<WebElement> elements = new ArrayList<WebElement>();
        for(WebElement EL:element){
            if(EL.getText().equals("Найти")){
                elements.add(EL);
            }
        }
        webElem = elements.get(0);
        Actions action = new Actions(driver);//Для клика по веб-элементу, который непрокликивается стандартным способом (это баг chromedriver'а)
        action.moveToElement(webElem).click().perform();

        //проверка на соответствие элеменов
//        webElem = driver.findElement(By.xpath("//div[contains(@h1, 'title.title_size_32.title_changeable_yes')]"));
//        webElem = driver.findElement(By.cssSelector("h1.title.title_size_32.title_changeable_yes"));
//        webElem = driver.findElement(By.xpath("//*[contains(@class, 'title_size_32')]"));

        /*webElem = driver.findElement(By.xpath("//div[@class='headline__header']/h1"));
        webElem.getText();
        System.out.println(webElem);*/

        //ожидаем, пока элемент не станет видимым
        while (true) {
            boolean breakIt = true;
            try {
                webElem = driver.findElement(By.linkText(nameElem));
                webElem.getText();
                Assert.assertSame(webElem, nameElem, "Elements are not match!");
            } catch (Exception e) {
                if (e.getMessage().contains("element is not attached")) {
                    breakIt = false;
                }
            }
            if (breakIt) {
                break;
            }

        }


    }


}
