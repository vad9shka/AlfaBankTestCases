package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 30.03.2016.
 */
public class Config {

    public WebDriver driver;

    public void saveScreenshot(){
        try {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd.MM.yyyy_HH-mm-ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            String filename = "screen_" + dateFormat.format(System.currentTimeMillis()) + ".png";
            String path = "Screenshots/" + filename;
            //сохраняем скриншот в каталоге path
            try {
                FileUtils.copyFile(screenshot, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Java_Projects\\SMP\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        //полноэкранный режим браузера
        driver.manage().window().maximize();

    }



}
