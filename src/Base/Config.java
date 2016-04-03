package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 30.03.2016.
 */
public class Config {

    public WebDriver driver;

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Java_Projects\\SMP\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //полноэкранный режим браузера
        driver.manage().window().maximize();

    }



}
