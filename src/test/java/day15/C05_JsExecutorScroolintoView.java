package day15;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScroolintoView extends TestBase {

    @Test
    public void scoolAction() throws InterruptedException {
        //hotelmycamp sitesine gidin
        driver.get("https://www.hotelmycamp.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(3000);
    }



    @Test
    public void scrollJsExecuto(){
        driver.get("https://www.hotelmycamp.com");


        //1.adım: JSE cast i oluştur
        JavascriptExecutor Jse=(JavascriptExecutor) driver;

        //2.adım: webele. lokeyt et
        WebElement odadetay2=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        //3.adım: Jse ile caliştir
        Jse.executeScript("arguments[0].scrollIntoView(true);",odadetay2);
        Jse.executeScript("arguments[0].click();",odadetay2);

    }
}
